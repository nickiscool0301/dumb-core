# Though process

## First thought DP
- dp[i] means the LIS end with nums[i]
- Loop i from 0 to end:
  -  Loop j from 0 to i-1:l
  - if nums[j] < nums[i] -> dp[i] = max(dp[i],dp[j]+1)
  - the max of dp is the result  




## Optimal solution: Binary Search
- res keep the smallest possible tail values for all increasing subsequences 
- loop each num in nums:
  - if num > res[-1], just append it to res
  - Else find the FIRST index where res[index] >= num, and replace res[index] with that num
  - return the len of res

```python
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = []
        for num in nums:
            if not res or res[-1] < num:
                res.append(num)
            else:
                index = bisect_left(res,num)
                res[index] = num
        return len(res)
```