package com.example.mybutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b1.setTooltipText("hello");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setBackgroundColor(Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
                //b1.setBackgroundColor(Color.RED);

            }
        });
        b3.setOnClickListener(new innerListener());
    }
    public void myListenerMethod(View v){
        String a = b2.getText().toString();
        b2.setText(b1.getText().toString());
        b1.setText(a);
    }
    public class innerListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            b3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 1);
        }
    }
}