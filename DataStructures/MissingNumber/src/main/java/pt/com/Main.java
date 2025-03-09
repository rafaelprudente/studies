package pt.com;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 5, 2, 6, 4};

        System.out.println(findMissingNumber(nums));
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }

        return expectedSum - numsSum;
    }
}