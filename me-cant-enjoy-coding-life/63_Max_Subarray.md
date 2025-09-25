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


### 25/09/2025
- Same observation
- Kadane's Algorithm

```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = nums[0]
        curr = nums[0]
        for num in nums[1:]:
            curr = max(num, curr + num)
            res = max(res, curr)
        return res
```

- Solve with divine and conquer
- when paritioning the array, there will be 3 cases:
    1. the max subarray is in the left part
    2. the max subarray is in the right part
    3. the max subarray crosses the middle point

- we will find max of those 3 cases

```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        def helper(l,r):
            if l == r:
                return nums[l]
            m = (l+r)//2
            leftMax = helper(l,m)
            rightMax = helper(m+1,r)

            # find the cross-mid max sum
            leftSub = float('-inf')
            temp = 0
            for i in range(m, l-1,-1):
                temp += nums[i]
                leftSub = max(leftSub, temp)

            rightSub = float('-inf')
            temp = 0
            for i in range(m+1, r+1):
                temp += nums[i]
                rightSub = max(rightSub, temp)
            return max(leftMax,rightMax,leftSub + rightSub)
        return helper(0, len(nums) - 1)
```



