package com.example.amchack;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Bird  {
    /*
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
        public Bird() {}

     */



    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("Size")
    @Expose
    private String size;
    @SerializedName("Picture")
    @Expose
    private String picture;
    @SerializedName("Sound")
    @Expose
    private String sound;
    @SerializedName("Familia")
    @Expose
    private String familia;
    @SerializedName("Ordo")
    @Expose
    private String ordo;
    @SerializedName("Genus")
    @Expose
    private String genus;
    @SerializedName("Meal")
    @Expose
    private String meal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getOrdo() {
        return ordo;
    }

    public void setOrdo(String ordo) {
        this.ordo = ordo;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    /*
    @Override
    public int describeContents() {
        return 0;
    }

     */


}
