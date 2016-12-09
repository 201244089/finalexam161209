package com.example.ryun.finalexam161209;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
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
    FrameLayout frLay1, frLay2, frLay3;
    LinearLayout page1, page2;
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
    }
}
