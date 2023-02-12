package com.example.test;

import java.util.HashMap;
import java.util.Map;

public class MapConverter {

    private Map<String, String> convertedMap = new HashMap<>();

    public Map<String, String> convertToMap(CardInfo cardInfo) {
        convertedMap.put("scheme", cardInfo.getScheme());
        convertedMap.put("type", cardInfo.getType());
        convertedMap.put("brand", cardInfo.getBrand());
        convertedMap.put("prepaid", String.valueOf(cardInfo.isPrepaid()));
        convertedMap.put("country", getCountryFullName(cardInfo));
        convertedMap.put("latitude", String.valueOf(cardInfo.getCountryInfo().getLatitude()));
        convertedMap.put("longitude", String.valueOf(cardInfo.getCountryInfo().getLongitude()));
        convertedMap.put("length", String.valueOf(cardInfo.getCardNumberInfo().getLength()));
        convertedMap.put("luhn", String.valueOf(cardInfo.getCardNumberInfo().isLuhn()));
        convertedMap.put("bankName", cardInfo.getBankInfo().getBankName());
        convertedMap.put("url", cardInfo.getBankInfo().getUrl());
        convertedMap.put("phone", cardInfo.getBankInfo().getPhone());

        return convertedMap;
    }

    private String getCountryFullName(CardInfo cardInfo) {
        String countryFullName = "";
        String countryName = cardInfo.getCountryInfo().getCountryName();
        String alpha2 = cardInfo.getCountryInfo().getAlpha2();
        if(!alpha2.isEmpty() || alpha2 != null) {
            countryFullName = String.format("%s %s",alpha2, countryName);
        } else {
            countryFullName = countryName;
        }
        return countryFullName;
    }

}
