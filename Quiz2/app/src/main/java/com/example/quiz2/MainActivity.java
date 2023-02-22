package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1.getText().toString().equals("Clicked")){
                    t1.setText("Not CLicked");
                }
                else{
                    t1.setText("Clicked");
                }
            }
        });
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(t2.getText().toString().equals("Clicked")){
            t2.setText("Not CLicked");
        }
        else{
            t2.setText("Clicked");
        }
    }
}