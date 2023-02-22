package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView latitudeText, longitudeText, cityText, currentWeatherText, timeText_1, temperature_time1, timeText_2, temperature_time2, timeText_3, temperature_time3, timeText_4, temperature_time4,tweetText, random;
    Button b1;
    EditText e1;
    ImageView image0, image1, image2, image3, image4;
    double lat, lon;
    String data = "";
    String weatherData = "";
    ArrayList<String> quotes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitudeText = findViewById(R.id.latitude);
        longitudeText = findViewById(R.id.longitude);
        cityText = findViewById(R.id.city);
        currentWeatherText = findViewById(R.id.current);
        timeText_1 = findViewById(R.id.timeText1);
        timeText_2 = findViewById(R.id.timeText2);
        timeText_3 = findViewById(R.id.timeText3);
        timeText_4 = findViewById(R.id.timeText4);
        temperature_time1 = findViewById(R.id.temperature_time1);
        temperature_time2 = findViewById(R.id.temperature_time2);
        temperature_time3 = findViewById(R.id.temperature_time3);
        temperature_time4 = findViewById(R.id.temperature_time4);
        tweetText = findViewById(R.id.tweetText);
        random = findViewById(R.id.textView);

        b1 = findViewById(R.id.button);
        e1 = findViewById(R.id.editTextNumber);

        image0 = findViewById(R.id.mainImage);
        image1 = findViewById(R.id.time1image);
        image2 = findViewById(R.id.time2image);
        image3 = findViewById(R.id.time3image);
        image4 = findViewById(R.id.time4image);

        quotes.add("No relationship is all sunshine, but two people can share one umbrella and survive the storm together.");
        quotes.add("Is that the sun coming up... or is that just you lighting up my world?");
        quotes.add("This weather and your face have something in common...I like it.");
        quotes.add("Black ice isn't the only thing I'm falling for.");
        quotes.add("Girl, when you don't text me back, I sometimes go into a tropical depression.");
        quotes.add("I wish I could write your name in the sky but the clouds will blow it away");
        quotes.add("Is your name honey? Cuz I'd love to drizzle you on my bland day.");
        quotes.add("You look like the morning sun after a long night of darkness.");
        quotes.add("Are you passed out on the sidewalk or are you my snow angel?");
        quotes.add("Did the sun come out or did you just smile at me?");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AsyncThread asyncThread = new AsyncThread();
                    asyncThread.execute(e1.getText().toString()).get();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public String putTime(int hour){
        String solution = "";
        solution += String.valueOf(hour%12);
        if(solution.equals("0")) {
            solution = "12";
        }
        if(hour%24 <12) {
            solution += "AM";
        }
        else{
            solution  += "PM";
        }
        return solution;
    }


    public class AsyncThread extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            String zip = strings[0];
            String json = new String("");
            String json2 = new String("");
            try {
                URL getCoord = new URL("https://api.openweathermap.org/geo/1.0/zip?zip=" + zip + ",US&appid=8c53389ece38fc06848808100ad83933");
                URLConnection urlcon= getCoord.openConnection();

                InputStream stream = urlcon.getInputStream();

                InputStreamReader isr = new InputStreamReader(stream);
                BufferedReader reader = new BufferedReader(isr);
                String currentLine;

                while ((currentLine = reader.readLine()) != null) {
                    json += currentLine;
                }
                data = json;
                JSONObject temp = new JSONObject(data);
                lat = temp.getDouble("lat");
                lon = temp.getDouble("lon");


                URL getWeather = new URL("https://api.openweathermap.org/data/2.5/forecast?lat=" + String.valueOf(lat) + "&lon=" + String.valueOf(lon) + "&appid=8c53389ece38fc06848808100ad83933&units=imperial");
                URLConnection urlcon2= getWeather.openConnection();
                InputStream stream2 = urlcon2.getInputStream();
                InputStreamReader isr2 = new InputStreamReader(stream2);
                BufferedReader reader2 = new BufferedReader(isr2);
                String currentLine2;
                while ((currentLine2 = reader2.readLine()) != null) {
                    json2 += currentLine2;
                }
                weatherData = json2;
            } catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            try {
                JSONObject normalData = new JSONObject(data);
                JSONObject weatherConditionsData = new JSONObject(weatherData);

                latitudeText.setText(String.format("%.2f", lat));
                longitudeText.setText(String.format("%.2f", lon));
                cityText.setText(weatherConditionsData.getJSONObject("city").getString("name"));
                currentWeatherText.setText(weatherConditionsData.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp") + "°F");
                LocalDate date = LocalDate.now();
                String low = weatherConditionsData.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_min") + "°F";
                String high = weatherConditionsData.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_max") + "°F";
                random.setText("current" + "   " + date + "   " + "("+ low + ", " + high + ")");

                temperature_time1.setText(weatherConditionsData.getJSONArray("list").getJSONObject(1).getJSONObject("main").getDouble("temp") + "°F");
                temperature_time2.setText(weatherConditionsData.getJSONArray("list").getJSONObject(2).getJSONObject("main").getDouble("temp") + "°F");
                temperature_time3.setText(weatherConditionsData.getJSONArray("list").getJSONObject(3).getJSONObject("main").getDouble("temp") + "°F");
                temperature_time4.setText(weatherConditionsData.getJSONArray("list").getJSONObject(4).getJSONObject("main").getDouble("temp") + "°F");
                int first_hour = LocalDateTime.now().getHour() + 3;
                timeText_1.setText(putTime(first_hour));
                timeText_2.setText(putTime(first_hour + 3));
                timeText_3.setText(putTime(first_hour + 6));
                timeText_4.setText(putTime(first_hour + 9));

                for(int i = 1; i<5; i++){
                    setImages(weatherConditionsData.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main"), i);
                }
                RelativeLayout layout = (RelativeLayout) findViewById(R.id.background);
                switch(weatherConditionsData.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("main")){
                    case "Clear":
                        layout.setBackgroundResource(R.drawable.mainclear);
                        List<Integer> options = Arrays.asList(2,7,9);
                        Collections.shuffle(options);
                        tweetText.setText(quotes.get(options.get(0)));
                        break;
                    case "Clouds":
                        layout.setBackgroundResource(R.drawable.mainclouds);
                        tweetText.setText(quotes.get(5));
                        break;
                    case "Drizzle":
                        layout.setBackgroundResource(R.drawable.maindrizzle);
                        tweetText.setText(quotes.get(6));
                        break;
                    case "Mist":
                        layout.setBackgroundResource(R.drawable.mainmist);
                        tweetText.setText(quotes.get(1));
                        break;
                    case "Rain":
                        layout.setBackgroundResource(R.drawable.mainrain);
                        tweetText.setText(quotes.get(0));
                        break;
                    case "Snow":
                        layout.setBackgroundResource(R.drawable.mainsnow);
                        List<Integer> options2 = Arrays.asList(3,8);
                        Collections.shuffle(options2);
                        tweetText.setText(quotes.get(options2.get(0)));
                        break;
                    case "Thunderstorm":
                        layout.setBackgroundResource(R.drawable.mainthunderstorm);
                        tweetText.setText(quotes.get(4));
                        break;
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    public void setImages(String condition, int imageNumber){
        int image = 0;
        switch(condition){
            case "Clear":
                image = R.drawable.clear;
                break;
            case "Clouds":
                image = R.drawable.clouds;
                break;
            case "Drizzle":
                image = R.drawable.drizzle;
                break;
            case "Mist":
                image = R.drawable.mist;
                break;
            case "Rain":
                image = R.drawable.rain;
                break;
            case "Snow":
                image = R.drawable.snow;
                break;
            case "Thunderstorm":
                image = R.drawable.thunderstorm;
                break;
        }
        switch(imageNumber){
            case 0:
                image0.setImageResource(image);
                break;
            case 1:
                image1.setImageResource(image);
                break;
            case 2:
                image2.setImageResource(image);
                break;
            case 3:
                image3.setImageResource(image);
                break;
            case 4:
                image4.setImageResource(image);
                break;
        }
    }
}