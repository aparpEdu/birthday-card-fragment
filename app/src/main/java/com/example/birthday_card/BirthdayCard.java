package com.example.birthday_card;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class BirthdayCard implements Parcelable {

    private String name;
    private String wishes;
    private int age;
    private String picture;

    public BirthdayCard(String name, String wishes, int age, String picture) {
        this.name = name;
        this.wishes = wishes;
        this.age = age;
        this.picture = picture;
    }

    protected BirthdayCard(Parcel in) {
        name = in.readString();
        wishes = in.readString();
        age = in.readInt();
        picture = in.readString();
    }

    public static final Creator<BirthdayCard> CREATOR = new Creator<BirthdayCard>() {
        @Override
        public BirthdayCard createFromParcel(Parcel in) {
            return new BirthdayCard(in);
        }

        @Override
        public BirthdayCard[] newArray(int size) {
            return new BirthdayCard[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(wishes);
        parcel.writeInt(age);
        parcel.writeString(picture);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
