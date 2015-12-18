package com.example.gebruiker.recyclerview.models;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Jan on 18/12/2015.
 */
@Accessors(prefix = "m")
@Data
@AllArgsConstructor
public class GOTCharacter implements Parcelable{
    private String mName;
    private String mDescription;
    private int mImage;

    protected GOTCharacter(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
        mImage = in.readInt();
    }

    public static final Creator<GOTCharacter> CREATOR = new Creator<GOTCharacter>() {
        @Override
        public GOTCharacter createFromParcel(Parcel in) {
            return new GOTCharacter(in);
        }

        @Override
        public GOTCharacter[] newArray(int size) {
            return new GOTCharacter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeInt(mImage);
    }
}
