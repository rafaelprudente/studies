package pt.com;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] orderedNums = {1, 3, 5, 7, 9};

        System.out.println(Arrays.toString(orderedNums));
        System.out.println("Target: 5 Position: " + binarySearch(orderedNums, 5));
        System.out.println("Target: 6 Position: " + binarySearch(orderedNums, 6));
    }

    private static int binarySearch(int[] nums, int target) {
        int response = -1;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                response = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return response;
    }
}