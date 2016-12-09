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

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Switch start_Swi;
    Chronometer cronoM;
    CalendarView calV;
    TimePicker timeP;
    EditText adult, child, kid;
    RadioGroup radioG1, radioG2;
    RadioButton rb1, rb4;
    ImageView img;
    TextView total, saleprice, totalprice;
    FrameLayout frLay1, frLay2;
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
        frLay1 = (FrameLayout) findViewById(R.id.frameLayout1);
        frLay2 = (FrameLayout)findViewById(R.id.framelayout2);
        img = (ImageView)findViewById(R.id.imageView);
        linLay1 = (LinearLayout)findViewById(R.id.switchlayout);
        linLay2 = (LinearLayout)findViewById(R.id.timelayout);
        rb1 =(RadioButton)findViewById(R.id.radioButton);
        rb4 =(RadioButton)findViewById(R.id.radioButton4);

        start_Swi.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if(on) {
                    cronoM.setBase(SystemClock.elapsedRealtime());
                    cronoM.start();
                    cronoM.setTextColor(Color.parseColor("#0000FF"));
                    cronoM.setVisibility(View.VISIBLE);
                }
                else {
                    cronoM.setBase(SystemClock.elapsedRealtime());
                    cronoM.stop();
                    cronoM.setTextColor(Color.parseColor("gray"));
                    cronoM.setVisibility(View.VISIBLE);
                    adult.setText("");
                    child.setText("");
                    kid.setText("");
                }
            }
        });



    }
}
