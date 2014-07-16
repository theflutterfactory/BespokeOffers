package com.julian.bespokeoffers;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by juliancurrie on 7/15/14.
 */
public class Offer implements Parcelable{

    private Offer(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {

    }

    private void readFromParcel(Parcel in) {

    }

    public static final Parcelable.Creator<Offer> CREATOR =
            new Parcelable.Creator<Offer>() {
                public Offer createFromParcel(Parcel in) {
                    return new Offer(in);
                }

                public Offer[] newArray(int size) {
                    return new Offer[size];
                }
            };
}
