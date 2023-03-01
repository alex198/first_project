package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Bank {

    @SerializedName("name")
    private String bankName;
    @SerializedName("url")
    private String url;
    @SerializedName("phone")
    private String phone;

    public Bank(String bankName, String url, String phone) {
        this.bankName = bankName;
        this.url = url;
        this.phone = phone;
    }

    public String getBankName() {
        return bankName;
    }

    public String getUrl() {
        return url;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Bank{" +
            "bankName='" + bankName + '\'' +
            ", url='" + url + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }

}
