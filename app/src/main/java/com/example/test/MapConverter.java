package com.example.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapConverter {

				private Map<String, String> convertedMap = new LinkedHashMap<>();

				public Map<String, String> convertToMap(CardInfo cardInfo) {
								convertedMap.put("Scheme", cardInfo.getScheme());
								convertedMap.put("Type", cardInfo.getType());
								convertedMap.put("Brand", cardInfo.getBrand());
								convertedMap.put("Prepaid", setBooleanToString(String.valueOf(cardInfo.isPrepaid())));
								convertedMap.put("Country", getCountryFullName(cardInfo));
								convertedMap.put(
												"Latitude/Longitude",
												cardInfo.getCountryInfo().getLatitude() + " " + cardInfo.getCountryInfo().getLongitude()
								);
								convertedMap.put("Length", String.valueOf(cardInfo.getCardNumberInfo().getLength()));
								convertedMap.put(
												"Luhn",
												setBooleanToString(String.valueOf(cardInfo.getCardNumberInfo().isLuhn()))
								);
								convertedMap.put("Bankname", cardInfo.getBankInfo().getBankName());
								convertedMap.put("URL", cardInfo.getBankInfo().getUrl());
								convertedMap.put("Phone", cardInfo.getBankInfo().getPhone());

								return new Utils().filterValue(convertedMap);
				}

				private String getCountryFullName(CardInfo cardInfo) {
								String countryFullName = "";
								String countryName = cardInfo.getCountryInfo().getCountryName();
								String alpha2 = cardInfo.getCountryInfo().getAlpha2();
								if (alpha2 != null && !alpha2.isEmpty()) {
												countryFullName = String.format("%s %s", alpha2, countryName);
								} else {
												countryFullName = countryName;
								}
								return countryFullName;
				}

				private String setBooleanToString(String s) {
								String result = "";
								if (s.equals("true")) {
												result = "Yes";
								} else if (s.equals("false")) {
												result = "No";
								}
								return result;
				}

}
