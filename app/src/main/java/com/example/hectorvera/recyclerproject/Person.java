package com.example.hectorvera.recyclerproject;

import android.graphics.Bitmap;

/**
 * Created by User on 10/10/2016.
 */

public class Person {

    private String name;
    private String date;
    private String description;
    private Bitmap image;

    public Person(){}

    public Person(String name, String date, String description){
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public Person(String name, String date, String description, Bitmap image){
        this.name = name;
        this.date = date;
        this.description = description;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
