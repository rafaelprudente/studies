package pt.com;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("swiss"));
        System.out.println(firstNonRepeating("sswwiiss"));
    }

    private static String firstNonRepeating(String str) {
        String response = "";

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                response = entry.getKey().toString();
                break;
            }
        }

        return response;
    }
}