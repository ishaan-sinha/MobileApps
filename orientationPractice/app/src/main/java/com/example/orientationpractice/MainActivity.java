package com.example.orientationpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textShow, textReturn;
    Spinner spinner;
    Button b1;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        textShow = findViewById(R.id.textShow);
        textReturn = findViewById(R.id.textReturn);
        b1 = findViewById(R.id.button);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            list = new ArrayList<String>();
            list.add("Jim");
            list.add("John");
            list.add("Jen");
            list.add("Jeff");
            list.add("Jerry");
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
            spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textShow.setText(list.get(i));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    textShow.setText("all elements removed");
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    spinnerAdapter.clear();

                    //spinner.setSelection(0);

                }
            });
        }
        else{
            textReturn.setText("This app only works in Portrait. Please rotate the screen");
        }

    }
}