package com.example.quiz1;

import static androidx.annotation.Dimension.DP;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.buttonRed);
        b2 = findViewById(R.id.buttonBlue);
        b3 = findViewById(R.id.buttonSize);
        size = 14;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setTextColor(Color.RED);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setTextColor(Color.BLUE);
                String temp = b1.getText().toString();
                b1.setText(b2.getText().toString());
                b2.setText(temp);
            }
        });
    }
    public void changeSize(View v){
        size++;
        //b3.setTextSize(COMPLEX_UNIT_DP, size);
        b3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
    }
}