package com.example.widgetdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch switchy;
    TextView switchText, displayTextBox, displaySeek;
    EditText textBox;
    SeekBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = findViewById(R.id.seekBar);
        displaySeek = findViewById(R.id.textViewSeek);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                displaySeek.setText(bar.getProgress()+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        switchy = findViewById(R.id.switch1);
        switchText = findViewById(R.id.textViewSwitch);
        switchy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean boo) {
                if(boo){switchText.setText("Happy Halloween");}
                else{switchText.setText("OFF");}
            }
        });

    textBox = findViewById(R.id.editTextTextPassword);
    displayTextBox = findViewById(R.id.textView3);
    textBox.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            displayTextBox.setText(charSequence);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });
    }
}