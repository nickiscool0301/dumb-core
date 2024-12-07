### URL: https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=dynamic-programming

### Think process:

- Detect: for a specific num in nums, we need to compare the previous value in dp[i-1], and the sum of nums[i] + dp[i-2].
- Basically, we have two situation, we can start at index 0 or index 1, and we need to keep track of the max for two values
  - The previous value in dp array
  - The sum of current num and dp[i-2] (not adjacent)
- return the dp[n-1];

```java
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[len-1];
    }
}
```