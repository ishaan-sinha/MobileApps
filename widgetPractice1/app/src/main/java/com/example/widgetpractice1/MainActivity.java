package com.example.widgetpractice1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2, t3;
    Switch s1;
    EditText e1;
    Button b1;
    SeekBar seek1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        s1 = findViewById(R.id.switch1);
        e1 = findViewById(R.id.editTextTextPersonName);
        b1 = findViewById(R.id.button);
        seek1 = findViewById(R.id.seekBar);
        seek1.setEnabled(false);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    t1.setTextColor(Color.GRAY);
                    t2.setTextColor(Color.BLACK);
                    seek1.setEnabled(true);
                }
                else{
                    t2.setTextColor(Color.GRAY);
                    t1.setTextColor(Color.BLACK);
                    seek1.setEnabled(false);
                }
            }
        });
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                switch(charSequence.toString().toLowerCase()){
                    case "green":
                        t3.setTextColor(Color.GREEN);
                        break;
                    case "blue":
                        t3.setTextColor(Color.BLUE);
                        break;
                    case "red":
                        t3.setTextColor(Color.RED);
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                b1.setWidth((seek1.getProgress() + 1) * 20);
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