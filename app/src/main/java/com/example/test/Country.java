package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    private String countryName;
    @SerializedName("alpha2")
    private String alpha2;
    @SerializedName("latitude")
    private int latitude;
    @SerializedName("longitude")
    private int longitude;

    public Country(String countryName, String alpha2, int latitude, int longitude) {
        this.countryName = countryName;
        this.alpha2 = alpha2;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Country{" +
            "countryName='" + countryName + '\'' +
            ", alpha2='" + alpha2 + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            '}';
    }
}
