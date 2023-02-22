package com.example.conversionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView t2,t3,t4,t5,t6,t7,t8,t9,t10;
    String c1 = "";
    String c2 = "";
    String c3 = "";
    String c4 = "";
    public static final String STRING_KEY1 = "save";
    public static final String STRING_KEY2 = "save";
    public static final String STRING_KEY3 = "save";
    public static final String STRING_KEY4 = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextNumber);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);
        t8 = findViewById(R.id.textView8);
        t9 = findViewById(R.id.textView9);
        t10 = findViewById(R.id.textView10);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if(savedInstanceState != null) {
                c1 = savedInstanceState.getString(STRING_KEY1);
                c2 = savedInstanceState.getString(STRING_KEY2);
                c3 = savedInstanceState.getString(STRING_KEY3);
                c4 = savedInstanceState.getString(STRING_KEY4);
            }
            t5.setText(c1);
            t2.setText(c2);
            t3.setText(c3);
            t4.setText(c4);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        double num = Double.valueOf(charSequence.toString());
                        t5.setText(2 * num + " Revelations");
                        t2.setText(3 * num + " Self Deprecations");
                        t3.setText(4 * num + " Existential Crises");
                        t4.setText(5 * num + " Meanies");
                    } catch (Exception e) {
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }else{
            if(savedInstanceState != null) {
                c1 = savedInstanceState.getString(STRING_KEY1);
                c2 = savedInstanceState.getString(STRING_KEY2);
                c3 = savedInstanceState.getString(STRING_KEY3);
                c4 = savedInstanceState.getString(STRING_KEY4);
            }
            t9.setText(c1);
            t7.setText(c2);
            t10.setText(c3);
            t8.setText(c4);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STRING_KEY1, t5.getText().toString());
        outState.putString(STRING_KEY2, t2.getText().toString());
        outState.putString(STRING_KEY3, t3.getText().toString());
        outState.putString(STRING_KEY4, t4.getText().toString());
    }

}