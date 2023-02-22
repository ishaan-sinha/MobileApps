package com.example.mybutton2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    int size1 = 16;
    int size2 = 16;
    int size3 = 16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setTooltipText("What a great button!");
        //button.setOnClickListener(new MyListener());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("This button works fr fr fax no printer");
                button1.setBackgroundColor(Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
                button1.setTextColor(Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));

                button1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size1);
                //size += 5;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size2);
                size2 = 1+(int)(Math.random()*100);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stored = "";
                button3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size3);
                stored = button1.getText().toString();
                button1.setText(button2.getText().toString());
                button2.setText(stored);
            }
        });
    }
    public void myListenerMethod(View v) {
        button1.setText("You clicked me!");
    }
    public class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            button1.setText("This button works fr fr");
        }
    }
}