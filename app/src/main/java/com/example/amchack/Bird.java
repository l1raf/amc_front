package com.example.amchack;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Bird implements Serializable, Parcelable {

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Color);
        parcel.writeString(Size);
        parcel.writeString(Picture);
        parcel.writeString(Sound);
        parcel.writeString(Familia);
        parcel.writeString(Ordo);
        parcel.writeString(Genus);
        parcel.writeString(Food);
    }

    public Bird(Parcel in) {
        Name = in.readString();
        Color = in.readString();
        Size = in.readString();
        Picture = in.readString();
        Sound = in.readString();
        Familia = in.readString();
        Ordo = in.readString();
        Genus = in.readString();
        Food = in.readString();
    }

    public Bird() {}

    public static final Creator<Bird> CREATOR = new Creator<Bird>() {
        @Override
        public Bird createFromParcel(Parcel in) {
            return new Bird(in);
        }

        @Override
        public Bird[] newArray(int size) {
            return new Bird[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    private String Color;

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    private String Size;

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    private String Picture;

    public String getSound() {
        return Sound;
    }

    public void setSound(String sound) {
        Sound = sound;
    }

    private String Sound;

    public String getFamilia() {
        return Familia;
    }

    public void setFamilia(String familia) {
        Familia = familia;
    }

    private String Familia;

    public String getOrdo() {
        return Ordo;
    }

    public void setOrdo(String ordo) {
        Ordo = ordo;
    }

    private String Ordo;

    public String getGenus() {
        return Genus;
    }

    public void setGenus(String genus) {
        Genus = genus;
    }

    private String Genus;

    public String getFood() {
        return Food;
    }

    public void setFood(String food) {
        Food = food;
    }

    private String Food;

    @Override
    public int describeContents() {
        return 0;
    }
}
