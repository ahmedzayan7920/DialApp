package com.example.dialapp;

import android.widget.ImageView;

public class Person {
    private String name;
    private String number;
    private int image;

    public Person(String name, String number, int image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
