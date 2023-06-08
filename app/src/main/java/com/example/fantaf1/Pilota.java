package com.example.fantaf1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONObject;

public class Pilota extends Char implements Parcelable {
    private String name;

    private int wins, podiums;

    public Pilota(Scuderia aScuderia, String aName, String aCode, int aWins, int aPodiums) {
        super(aScuderia);
        name = aName;
        wins = aWins;
        podiums = aPodiums;
    }

    protected Pilota(Parcel in) {
        super(in);
        name = in.readString();
        wins = in.readInt();
        podiums = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(name);
        dest.writeInt(wins);
        dest.writeInt(podiums);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pilota> CREATOR = new Creator<Pilota>() {
        @Override
        public Pilota createFromParcel(Parcel in) {
            return new Pilota(in);
        }

        @Override
        public Pilota[] newArray(int size) {
            return new Pilota[size];
        }
    };

    @Override
    public void addPoint(JSONObject result) {
        try {
            if ((boolean)result.get("giroVeloce"))
                punti += 5;
            switch ((int)result.get("pos")){
                case 1: punti += 25;
                break;
                case 2: punti += 18;
                break;
                case 3: punti += 15;
                break;
                case 4: punti += 12;
                break;
                case 5: punti += 10;
                break;
                case 6: punti += 8;
                break;
                case 7: punti += 6;
                break;
                case 8: punti += 4;
                break;
                case 9: punti += 2;
                break;
                case 10: punti += 1;
                break;
                case -1: punti -= 20;
                break;
                default:
                    break;
            }
        }catch (Exception e){}
    }

}
