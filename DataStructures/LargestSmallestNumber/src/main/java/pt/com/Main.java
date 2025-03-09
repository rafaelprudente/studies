package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println("Min: " + findMin(new int[]{3, 5, 7, 2, 8, -1}));
        System.out.println("Min: " + findMax(new int[]{3, 5, 7, 2, 8, -1}));
    }

    private static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) min = num;
        }

        return min;
    }

    private static int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) max = num;
        }

        return max;
    }
}