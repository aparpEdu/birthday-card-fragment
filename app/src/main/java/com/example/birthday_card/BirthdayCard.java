package com.example.birthday_card;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class BirthdayCard implements Parcelable {

    private final String name;
    private final String wishes;
    private final int age;
    private final  String picture;

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


    public String getWishes() {
        return wishes;
    }



    public int getAge() {
        return age;
    }



    public String getPicture() {
        return picture;
    }


}
