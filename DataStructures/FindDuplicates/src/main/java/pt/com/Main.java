package pt.com;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] values1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] values2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 5};

        System.out.println(hasDuplicate(values1)? "Has Duplicates" : "Has not duplicates");
        System.out.println(hasDuplicate(values2)? "Has Duplicates" : "Has not duplicates");
    }

    private static boolean hasDuplicate(int[] arr) {
        boolean hasDuplicate = false;

        Set<Integer> set = new HashSet<>();
        for(int value : arr) {
            if(!set.add(value)) {
                hasDuplicate = true;
                break;
            }
        }

        return hasDuplicate;
    }
}