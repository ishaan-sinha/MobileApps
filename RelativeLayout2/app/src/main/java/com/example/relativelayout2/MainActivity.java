package com.example.relativelayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        text3 = findViewById(R.id.textView3);
        text4 = findViewById(R.id.textView4);
        text5 = findViewById(R.id.textView5);
    }
    public void OnClick(View v){

    }
    public void f1(View v){
        if(text1.getText().toString().equals("On")){
            text1.setText("Off");
        }
        else{
            text1.setText("On");
        }
    }
    public void f2(View v){
        if(text2.getText().toString().equals("On")){
            text2.setText("Off");
        }
        else{
            text2.setText("On");
        }
    }
    public void f3(View v){
        if(text3.getText().toString().equals("On")){
            text3.setText("Off");
        }
        else{
            text3.setText("On");
        }
    }
    public void f4(View v){
        if(text4.getText().toString().equals("On")){
            text4.setText("Off");
        }
        else{
            text4.setText("On");
        }
    }
    public void f5(View v){
        if(text5.getText().toString().equals("On")){
            text5.setText("Off");
        }
        else{
            text5.setText("On");
        }
    }
}