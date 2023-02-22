package com.example.gpsapp;

import android.location.Location;

public class LocTime {

    Location location;
    double time;

    public LocTime(Location location, double time){
        this.location = location;
        this.time = time;
    }
    public double getTime(){
        return this.time;
    }
    public Location getLocation(){
        return this.location;
    }

    public void addTime(double t){
        time += t;
    }
}
