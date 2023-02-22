package com.example.bollywoodapp;

public class Actor{
    private int image;
    private String name;
    private String latestMovie;
    private Double movieGross;
    private int movieImage;
    private String date;

    public Actor(int image, String name, String latestMovie, Double movieGross, int movieImage, String date){
        this.image = image;
        this.name = name;
        this.latestMovie = latestMovie;
        this.movieGross = movieGross;
        this.movieImage = movieImage;
        this.date = date;
    }

    public int getImage(){
        return image;
    }
    public String getName(){
        return name;
    }
    public String getLatestMovie(){return latestMovie;}
    public Double getMovieGross(){
        return movieGross;
    }
    public int getMovieImage(){return movieImage; }
    public String getDate() {return date;}
}