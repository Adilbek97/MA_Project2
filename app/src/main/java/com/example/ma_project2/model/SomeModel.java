package com.example.ma_project2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SomeModel implements Parcelable {
    private String name;
    private int age;

    protected SomeModel(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<SomeModel> CREATOR = new Creator<SomeModel>() {
        @Override
        public SomeModel createFromParcel(Parcel in) {
            return new SomeModel(in);
        }

        @Override
        public SomeModel[] newArray(int size) {
            return new SomeModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeInt(age);
    }
}
