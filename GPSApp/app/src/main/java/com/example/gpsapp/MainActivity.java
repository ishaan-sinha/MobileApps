package com.example.gpsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {
    TextView textLon, textLat, textAddress, textDistance;
    LocationManager location;
    Location oldLocation;
    ArrayList<LocTime> locationTimes;
    Geocoder geocoder;
    Button b1;
    float distance_travelled = 0f;
    public static final String STRING_KEY = "save";

    double oldTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLon = findViewById(R.id.latitude);
        textLat = findViewById(R.id.longitude);
        textAddress = findViewById(R.id.address);
        textDistance = findViewById(R.id.distance);
        b1 = findViewById(R.id.button);
        locationTimes = new ArrayList<LocTime>();

        location = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        if(savedInstanceState != null){
            distance_travelled = savedInstanceState.getFloat(STRING_KEY);
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            String[] permissions = {android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION,};
            ActivityCompat.requestPermissions(this, permissions, 2);
            return;
        }
        else{location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, .5f, this);}

        geocoder = new Geocoder(this, Locale.US);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distance_travelled = 0f;
                textDistance.setText(String.valueOf(distance_travelled / 1609.34) + " miles");
            }
        });
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        boolean isThere = false;
        if(oldLocation != null) {
            for (LocTime i : locationTimes) {
                if (i.getLocation().equals(oldLocation)) {
                    isThere = true;
                }
            }
            if (!isThere) {
                locationTimes.add(new LocTime(oldLocation, 0.0));
            }
            for (LocTime i : locationTimes) {
                if (i.getLocation().equals(oldLocation)) {
                    i.addTime(SystemClock.elapsedRealtime() - oldTime);
                    oldTime = SystemClock.elapsedRealtime();
                }
            }
        }


        double lat = location.getLatitude();
        double lon = location.getLongitude();
        textLat.setText(String.format("%,.4f", lat));
        textLon.setText(String.format("%,.4f", lon));
        List<Address> addressList;
        try {
            addressList = geocoder.getFromLocation(lat, lon, 1);
            textAddress.setText(addressList.get(0).getAddressLine(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(oldLocation != null){
            distance_travelled += location.distanceTo(oldLocation);
        }
        oldLocation = location;
        textDistance.setText(String.format("%,.4f", distance_travelled / 1609.34) + " miles");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, .1f, this);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(STRING_KEY, distance_travelled);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}

