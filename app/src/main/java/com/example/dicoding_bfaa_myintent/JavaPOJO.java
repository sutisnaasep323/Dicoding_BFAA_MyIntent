package com.example.dicoding_bfaa_myintent;

import android.os.Parcel;
import android.os.Parcelable;

public class JavaPOJO implements Parcelable {
    private String name;
    private int age;
    private String email;
    private String city;

    protected JavaPOJO(Parcel in) {
        name = in.readString();
        age = in.readInt();
        email = in.readString();
        city = in.readString();
    }

    public static final Creator<JavaPOJO> CREATOR = new Creator<JavaPOJO>() {
        @Override
        public JavaPOJO createFromParcel(Parcel in) {
            return new JavaPOJO(in);
        }

        @Override
        public JavaPOJO[] newArray(int size) {
            return new JavaPOJO[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeString(email);
        parcel.writeString(city);
    }
}
