package com.example.widgetsimageviewradiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton b1,b2,b3;
    TextView selection;
    ImageView leftImage, rightImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        b1 = findViewById(R.id.radioButton);
        b2 = findViewById(R.id.radioButton2);
        b3 = findViewById(R.id.radioButton3);
        selection = findViewById(R.id.textView);
        leftImage = findViewById(R.id.imageViewLeft);
        rightImage = findViewById(R.id.imageViewRight);
        leftImage.setImageResource(R.drawable.skywalker);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButton){selection.setText("A selected");}
                if(i == R.id.radioButton2){selection.setText("B selected");}
                if(i == R.id.radioButton3){
                    selection.setText("C selected");
                    //Toast myMessage = Toast.makeText(MainActivity.this, "C is the best",Toast.LENGTH_LONG);
                    //myMessage.show();
                    Toast.makeText(MainActivity.this, "C is the best",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}