package com.example.bollywoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<Actor> maleNames = new ArrayList<>();
    static ArrayList<Actor> femaleNames = new ArrayList<>();
    static ArrayList<Integer> switched = new ArrayList<>();
    public static final String STRING_KEY = "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleNames = new ArrayList<>();
        femaleNames = new ArrayList<>();
        maleNames.add(new Actor(R.drawable.khan, "Shah Rukh Khan", "Zero", 191.43, R.drawable.zero, "12/21/2018"));

        maleNames.add(new Actor(R.drawable.kumar,"Akshay Kumar", "Ram Setu", 92.94, R.drawable.ramsetu, "10/25/2022"));
        maleNames.add(new Actor(R.drawable.roshan, "Hrithik Roshan", "Vikram Vedha", 135.03, R.drawable.vikramvedha, "09/30/2022"));
        maleNames.add(new Actor(R.drawable.kapoor,"Ranbir Kapoor", "Brahmastra", 431.0, R.drawable.brahmastra, "09/09/2022"));
        maleNames.add(new Actor(R.drawable.malhotra, "Sidharth Malhotra", "Thank God", 49.55, R.drawable.thankgod, "09/25/2022"));
        maleNames.add(new Actor(R.drawable.dhawan,"Varun Dhawan", "Bhediya", 86.5, R.drawable.bhediya, "11/25/2022"));
        maleNames.add(new Actor(R.drawable.aaryan, "Kartik Aaryan", "Bhool Bhulaiyaa 2", 266.88, R.drawable.bhoolbhulaiyaa2, "05/20/2022"));
        maleNames.add(new Actor(R.drawable.shroff, "Tiger Shroff","Heropanti 2", 35.13, R.drawable.heropanti2, "04/29/2022"));
        femaleNames.add(new Actor(R.drawable.padukone,"Deepika Padukone", "83", 193.73, R.drawable.movie83, "12/24/2021"));
        femaleNames.add(new Actor(R.drawable.bhatt, "Alia Bhatt", "Brahmastra", 431.0, R.drawable.brahmastra, "09/09/2022"));
        femaleNames.add(new Actor(R.drawable.kaif, "Katrina Kaif", "Phone Bhoot", 18.73, R.drawable.phonebhoot, "11/04/2022"));
        femaleNames.add(new Actor(R.drawable.sharma, "Anushka Sharma", "Zero", 191.43, R.drawable.zero, "12/21/2018"));
        femaleNames.add(new Actor(R.drawable.skapoor, "Shraddha Kapoor", "Baaghi 3", 137.0, R.drawable.baaghi3, "03/06/2020"));
        femaleNames.add(new Actor(R.drawable.advani,"Kiara Advani", "Jugjugg Jeeyo", 136.13, R.drawable.jugjuggjeeyo, "06/24/2022"));
        femaleNames.add(new Actor(R.drawable.sanon,"Kriti Sanon", "Bhediya", 86.5, R.drawable.bhediya, "11/25/2022"));
        femaleNames.add(new Actor(R.drawable.fernandez,"Jacqueline Fernandez","Cirkus", 42.26, R.drawable.cirkus, "12/23/2022"));

        if(savedInstanceState != null){
            switched = savedInstanceState.getIntegerArrayList(STRING_KEY);
        }
        for (int i:switched){
            change(i);
        }

        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, maleNames);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            listview = findViewById(R.id.listid);
            listview.setAdapter(adapter);
        }
        else{
            listview = findViewById(R.id.listid2);
            listview.setAdapter(adapter);
            Log.d("hi", "reached");
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d("hi", "clicked");
                    Actor item = maleNames.get(i);
                    ImageView image2 = findViewById(R.id.imageView2);
                    image2.setImageResource(item.getMovieImage());
                    TextView netGross = findViewById(R.id.textView2);
                    netGross.setText(item.getMovieGross() + " crore rupees");
                    CalendarView calendar = findViewById(R.id.calendarView);
                    String[] date = item.getDate().split("/");
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date current = null;
                    try {
                        current = sdf.parse(item.getDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long timeInMillis = current.getTime();
                    System.out.println(timeInMillis);
                    calendar.setDate(timeInMillis);

                }
            });

        }

    }

    public void change(int position){
        Actor temp = femaleNames.get(position);
        femaleNames.set(position, maleNames.get(position));
        maleNames.set(position, temp);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("LIFECYCLE","SAVE");
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(STRING_KEY, switched);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LIFECYCLETAG","RESTORE");
    }

}