package com.example.widgetpractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Switch s1;
    Switch s2;
    Switch s3;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t7;
    EditText e1;
    EditText e2;
    Button b1;
    Button b2;
    TextView t5;
    TextView t6;
    SeekBar sk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.switch1);
        s2 = findViewById(R.id.switch2);
        s3 = findViewById(R.id.switch3);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);


        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    t1.setText("On");
                }
                else{
                    t1.setText("Off");
                }
                if(b && s2.isChecked() && s3.isChecked()){t4.setTextColor(Color.BLUE);}
                if(b && s3.isChecked() && !s3.isChecked()){t4.setTextColor(Color.RED);}
                if(!b && s3.isChecked() && !s2.isChecked()){t4.setTextColor(Color.GREEN);}
            }
        });
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    t2.setText("On");
                }
                else{
                    t2.setText("Off");
                }
                if(b && s1.isChecked() && s3.isChecked()){t4.setTextColor(Color.BLUE);}
                if(!b && s1.isChecked() && s3.isChecked()){t4.setTextColor(Color.RED);}
                if(!b && s3.isChecked() && !s1.isChecked()){t4.setTextColor(Color.GREEN);}
            }
        });
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    t3.setText("On");
                }
                else{
                    t3.setText("Off");
                }
                if(b && s1.isChecked() && s3.isChecked()){t4.setTextColor(Color.BLUE);}
                if(b && s1.isChecked() && !s2.isChecked()){t4.setTextColor(Color.RED);}
                if(b && !s2.isChecked() && !s1.isChecked()){t4.setTextColor(Color.GREEN);}
            }
        });
        e1 = findViewById(R.id.editTextTextEmailAddress);
        b1 = findViewById(R.id.button);
        t5 = findViewById(R.id.textView5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = e1.getText().toString();
                if(a.contains("@") && a.contains(".com") && a.indexOf("@")<a.indexOf(".com")){
                    t5.setText("Verified");
                } else{ t5.setText("Not Verified");}
            }
        });
        e2 = findViewById(R.id.editTextTextEmailAddress2);
        b2 = findViewById(R.id.button2);
        t6 = findViewById(R.id.textView5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = e2.getText().toString();
                List<String> list=new ArrayList<String>(){{
                    add("a@b.com");
                    add("c@d.com");
                    add("e@f.com");
                }};
                if(list.contains(a)){ t6.setText("In Database");}else{t6.setText("Not In Database");}
            }
        });
        sk1 = findViewById(R.id.seekBar);
        t7 = findViewById(R.id.textView7);
        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                t7.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}