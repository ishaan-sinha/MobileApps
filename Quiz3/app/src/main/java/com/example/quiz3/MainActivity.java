package com.example.quiz3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    Switch s1;
    TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextTextPersonName);
        e2 = findViewById(R.id.editTextTextPersonName2);
        b1 = findViewById(R.id.button);
        s1 = findViewById(R.id.switch1);
        t3 = findViewById(R.id.textView3);
        ArrayList<String> usedPasswords = new ArrayList<String>();
        usedPasswords.add("test");
        usedPasswords.add("password");
        usedPasswords.add("123");
        usedPasswords.add("abc");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().equals(e2.getText().toString()) && usedPasswords.indexOf(e1.getText().toString()) == -1){
                    s1.setChecked(true);
                    s1.setText("Match");
                }
                else{
                    s1.setChecked(false);
                    s1.setText("Does Not Match");
                }
            }
        });
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(usedPasswords.indexOf(e1.getText().toString()) != -1){
                    t3.setText("Password Already Used");
                } else{
                    t3.setText("Password not previously used");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}