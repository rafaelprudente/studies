package pt.com;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum subarray sum: " + maxSubarraySum(nums));
    }

    public static int maxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for (int number : nums) {
            maxEndingHere = Math.max(number, maxEndingHere + number);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}