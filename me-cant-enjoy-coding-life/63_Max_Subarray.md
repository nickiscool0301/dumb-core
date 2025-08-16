URL: https://leetcode.com/problems/maximum-subarray/description/

## Approach:
- Prefix sum
- Observation

## Solution
### 11/24/2024
- Observation is that, whenever we iterate from left the right for each number. If the current sum before that is negative, we should restart the sum to make sure it is maximized.
- initialize max and currentSum
- if currentSum is less than zero, set it to 0
- add the current num to current sum, then update the max
- return the max

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num : nums) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum += num;
            max = Math.max(max, currSum);
        }
        return max;
    }
}
```