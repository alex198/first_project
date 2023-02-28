package com.example.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public Map<String, String> filterValue(Map<String, String> map) {
        Map<String, String> result = new LinkedHashMap<>();
        List<Map.Entry<String, String>> listMap = new ArrayList<>(map.entrySet());
        for (int i = 0; i < listMap.size(); i++) {
            Map.Entry<String, String> item = listMap.get(i);
            String value = item.getValue();
            if (value != null && !value.isEmpty()) {
                result.put(item.getKey(), value);
            }
        }
        return result;
    }

}
