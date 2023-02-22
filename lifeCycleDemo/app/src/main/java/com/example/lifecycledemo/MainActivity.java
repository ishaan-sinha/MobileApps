package com.example.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.telecom.Conference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView port, land;
    Button button;
    int count = 0;
    public static final String STRING_KEY = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        port = findViewById(R.id.textView);
        land = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.d("LIFECYCLETAG","Portrait onCreate");

            if(savedInstanceState != null){
                count = savedInstanceState.getInt(STRING_KEY);
            }
            port.setText("count "+count);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG","onClick");
                    count ++;
                    port.setText("count "+count);
                }
            });
        } else{
            Log.d("LIFECYCLETAG","Landscape onCreate");
            if(savedInstanceState != null){
                count = savedInstanceState.getInt(STRING_KEY);
            }
            land.setText("count "+count);
        }
    }

    @Override
    protected void onStart() {
        Log.d("LIFECYCLETAG", "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("LIFECYCLETAG", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("LIFECYCLETAG", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LIFECYCLETAG", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("LIFECYCLETAG", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LIFECYCLETAG", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("LIFECYCLE","SAVE");
        super.onSaveInstanceState(outState);
        outState.putInt(STRING_KEY, count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LIFECYCLETAG","RESTORE");
    }
}