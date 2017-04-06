package com.example.kimja.a5thclass;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kimja on 2017-04-06.
 */

public class student implements Parcelable{
    private String name = "";
    private String hakno = "";
    private int age = 0;
    private int isman = 1;

    @Override
    public String toString() {
        String str = name + ":" + hakno + ":" + age + ":" + isman ;
        return str;
    }

    public student(String name , String hakno, int age, int isman){
        this.name = name;
        this.hakno = hakno;
        this.age = age;
        this.isman = isman;
    }

    protected student(Parcel in) {
        name = in.readString();
        hakno = in.readString();
        age = in.readInt();
        isman = in.readInt();
    }

    public static final Creator<student> CREATOR = new Creator<student>() {
        @Override
        public student createFromParcel(Parcel in) {
            return new student(in);
        }

        @Override
        public student[] newArray(int size) {
            return new student[size];
        }
    };

    public void setstudent (String name , String hakno, int age, int isman){
        this.name = name;
        this.hakno = hakno;
        this.age = age;
        this.isman = isman;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(hakno);
        dest.writeInt(age);
        dest.writeInt(isman);
    }
}
