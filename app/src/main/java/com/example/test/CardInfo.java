package com.example.test;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CardInfo implements Serializable {

    @SerializedName("scheme")
    private String scheme;
    @SerializedName("type")
    private String type;
    @SerializedName("brand")
    private String brand;
    @SerializedName("prepaid")
    private boolean prepaid;
    @SerializedName("country")
    private Country country;
    @SerializedName("number")
    private CardNumber number;
    @SerializedName("bank")
    private Bank bank;

    public CardInfo(
            String scheme,
            String type,
            String brand,
            boolean prepaid,
            Country country,
            CardNumber number,
            Bank bank
    ) {
        this.scheme = scheme;
        this.type = type;
        this.brand = brand;
        this.prepaid = prepaid;
        this.country = country;
        this.number = number;
        this.bank = bank;
    }

    public String getScheme() {
        return scheme;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public Country getCountryInfo() {
        return country;
    }

    public CardNumber getCardNumberInfo() {
        return number;
    }

    public Bank getBankInfo() {
        return bank;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "scheme='" + scheme + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", prepaid=" + prepaid +
                ", countryInfo=" + country +
                ", cardNumberInfo=" + number +
                ", bankInfo=" + bank +
                '}';
    }
}
