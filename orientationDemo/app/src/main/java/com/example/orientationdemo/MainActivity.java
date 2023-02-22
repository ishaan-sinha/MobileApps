package com.example.orientationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView port1, port2, land1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        port1 = findViewById(R.id.topTextView);
        port2 = findViewById(R.id.bottomTextView);
        land1 = findViewById(R.id.textView);

        Log.d("ORIENTATIONTAG", getResources().getConfiguration().orientation+"");

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "We are in portrait mode", Toast.LENGTH_SHORT).show();

        }
        else{
            land1.setText("land1");
            Toast.makeText(this, "We are in landscape mode", Toast.LENGTH_SHORT).show();

        }
    }
}