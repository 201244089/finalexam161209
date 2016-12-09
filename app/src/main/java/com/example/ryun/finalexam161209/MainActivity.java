package com.example.ryun.finalexam161209;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    RadioButton rbtn1;
    RadioButton rbtn2;
    RadioButton rbtn3;
    RadioButton rbtn4;
    RadioButton rbtn5;
    Switch start_Swi;
    Chronometer cronoM;
    CalendarView calV;
    TimePicker timeP;
    EditText adult, child, kid;
    RadioGroup radioG1, radioG2;
    RadioButton rb1, rb4;
    ImageView img;
    TextView total, saleprice, totalprice;
    FrameLayout frLay1, frLay2, textbg;
    LinearLayout linLay1, linLay2;
    int year=-1;
    int mon=-1;
    int day=-1;
    int hour=-1;
    int min=-1;
    int flag =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("놀이동산 예약시스템");

        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        rbtn1 = (RadioButton)findViewById(R.id.radioButton);
        rbtn2 = (RadioButton)findViewById(R.id.radioButton2);
        rbtn3 = (RadioButton)findViewById(R.id.radioButton3);
        rbtn4 = (RadioButton)findViewById(R.id.radioButton4);
        rbtn5 = (RadioButton)findViewById(R.id.radioButton5);
        start_Swi = (Switch)findViewById(R.id.switch1);
        cronoM = (Chronometer)findViewById(R.id.chronometer);
        calV = (CalendarView)findViewById(R.id.calendarView);
        timeP = (TimePicker)findViewById(R.id.timePicker);
        adult = (EditText) findViewById(R.id.editText1);
        child = (EditText) findViewById(R.id.editText2);
        kid = (EditText) findViewById(R.id.editText3);
        radioG1 = (RadioGroup) findViewById(R.id.rgroup);
        radioG2 = (RadioGroup) findViewById(R.id.rgroup2);
        total = (TextView) findViewById(R.id.textView5);
        saleprice = (TextView) findViewById(R.id.textView6);
        totalprice = (TextView) findViewById(R.id.textView7);
        textbg = (FrameLayout)findViewById(R.id.framelayout);
        frLay1 = (FrameLayout) findViewById(R.id.frameLayout1);
        frLay2 = (FrameLayout)findViewById(R.id.framelayout2);
        img = (ImageView)findViewById(R.id.imageView);
        linLay1 = (LinearLayout)findViewById(R.id.switchlayout);
        linLay2 = (LinearLayout)findViewById(R.id.timelayout);

        start_Swi.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    cronoM.setBase(SystemClock.elapsedRealtime());
                    cronoM.start();
                    cronoM.setTextColor(Color.parseColor("#0000FF"));
                    cronoM.setVisibility(View.VISIBLE);
                    frLay1.setVisibility(View.VISIBLE);
                    linLay1.setVisibility(View.VISIBLE);
                    textbg.setVisibility(View.VISIBLE);
                    linLay2.setVisibility(View.INVISIBLE);
                }
                else {
                    cronoM.setBase(SystemClock.elapsedRealtime());
                    cronoM.stop();
                    cronoM.setTextColor(Color.parseColor("gray"));
                    cronoM.setVisibility(View.VISIBLE);
                    frLay1.setVisibility(View.INVISIBLE);
                    frLay2.setVisibility(View.INVISIBLE);
                    linLay1.setVisibility(View.INVISIBLE);
                    textbg.setVisibility(View.INVISIBLE);
                    linLay2.setVisibility(View.INVISIBLE);
                    adult.setText("");
                    child.setText("");
                    kid.setText("");
                }
            }
        });


        rbtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    img.setImageResource(R.drawable.everland);
                }
            }
        });
        rbtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    img.setImageResource(R.drawable.money);
                }
            }
        });
        rbtn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    img.setImageResource(R.drawable.card);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!adult.getText().toString().matches("^[0-9]+$")||!child.getText().toString().matches("^[0-9]+$")||!kid.getText().toString().matches("^[0-9]+$")) {
                    Toast.makeText(getApplicationContext(),"인원을 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                double harin=0.05;
                if(rbtn2.isChecked()) harin=0.1;
                else if (rbtn3.isChecked()) harin=0.2;

                int text1 = Integer.parseInt(adult.getText().toString());
                int text2 = Integer.parseInt(child.getText().toString());
                int text3 = Integer.parseInt(kid.getText().toString());
                total.setText("총 명수 : "+((text1+text2+text3)));
                saleprice.setText("할인 금액 : "+((int) Math.round((text1*15000+text2*12000+text3*8000)*harin/10)*10));
                totalprice.setText("결제 금액 : "+((text1*15000+text2*12000+text3*8000)-((int) Math.round((text1*15000+text2*12000+text3*8000)*harin/10)*10)));
                flag=1;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textbg.setBackgroundColor(Color.parseColor("#E0FFFF"));
                linLay1.setVisibility(View.INVISIBLE);
                linLay2.setVisibility(View.VISIBLE);
            }
        });


        calV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                year = i;
                mon = i1;
                day = i2;
            }
        });

        timeP.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour = i;
                min = i1;
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    Toast.makeText(getApplicationContext(),"인원예약을 먼저 하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(year==-1||min==-1) {
                    Toast.makeText(getApplicationContext(),"날짜와 시간을 입력하세요!",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),year+"-"+mon+"-"+day+" "+hour+":"+min+" 예약완료되었습니다.",Toast.LENGTH_SHORT).show();
                cronoM.stop();
                cronoM.setTextColor(Color.GRAY);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linLay1.setVisibility(View.VISIBLE);
                linLay2.setVisibility(View.INVISIBLE);
            }
        });



    }

}
