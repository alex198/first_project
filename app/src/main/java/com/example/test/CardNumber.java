package com.example.test;

import com.google.gson.annotations.SerializedName;

public class CardNumber {

    @SerializedName("length")
    private int length;
    @SerializedName("luhn")
    private boolean luhn;

    public CardNumber(int length, boolean luhn) {
        this.length = length;
        this.luhn = luhn;
    }

    public int getLength() {
        return length;
    }

    public boolean isLuhn() {
        return luhn;
    }

    @Override
    public String toString() {
        return "CardNumber{" +
                "length=" + length +
                ", luhn=" + luhn +
                '}';
    }
}
