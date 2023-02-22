package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        JSONObject schoolInfo = new JSONObject();

        try {
            schoolInfo.put("name", "Siya");
            schoolInfo.put("grade", 11);
            schoolInfo.put("id", 12706);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("school", schoolInfo.toString());
        try {
            textView.setText(schoolInfo.get("name").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject compSci = new JSONObject();
        try {
            compSci.put("grade", "A");
            compSci.put("percentage", 100000);
            schoolInfo.put("Computer Science", compSci);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("school", schoolInfo.toString());

        JSONObject findCourse;
        try {
            findCourse = schoolInfo.getJSONObject("Computer Science");
            textView.setText(findCourse.get("percentage").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray clubs = new JSONArray();
        try {
            clubs.put("Robotics");
            clubs.put("Public Health");

            JSONObject csClub = new JSONObject();
            csClub.put("Advisor", "Ms. Robles");
            clubs.put(csClub);
            schoolInfo.put("clubs", clubs);
        } catch(JSONException e){ e.printStackTrace();}

        Log.d("clubs", clubs.toString());
        Log.d("school", schoolInfo.toString());
    }
}