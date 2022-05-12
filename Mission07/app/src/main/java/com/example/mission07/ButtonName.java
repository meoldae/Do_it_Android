package com.example.mission07;

import android.os.Parcel;
import android.os.Parcelable;

public class ButtonName implements Parcelable {
    String name;

    public ButtonName(String str){
        name = str;
    }

    public ButtonName(Parcel src){
        name = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public ButtonName createFromParcel(Parcel in) {
            return new ButtonName(in);
        }

        @Override
        public ButtonName[] newArray(int size) {
            return new ButtonName[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
