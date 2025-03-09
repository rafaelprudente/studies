package pt.com;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(areAnagrams("test2", "test3"));
    }

    private static boolean areAnagrams(String s1, String s2) {
        boolean response = false;

        if (s1.length() == s2.length()) {
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            response = Arrays.equals(arr1, arr2);
        }

        return response;
    }
}