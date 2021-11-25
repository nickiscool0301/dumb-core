// Given an integer array nums, find the contiguous subarray (containing at least one number) which 
// has the largest sum and return its sum.

// A subarray is a contiguous part of an array.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Example 2:

// Input: nums = [1]
// Output: 1

//Method: Dynamic Programming: maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]; 

class MaximumSubarray_53 {
    public static int maxSubArray(int[] nums) {
        int s = nums.length;
        int[] dp = new int[s];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < s; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] s = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(s));
    }
}