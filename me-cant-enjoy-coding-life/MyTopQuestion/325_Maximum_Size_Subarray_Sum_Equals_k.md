- This is a premium leetcode problem

## Notes

- Brute force: take O(N^3)
- Use hashmap and prefix sum

## Solution

### 11/24/2024

- it takes me a while to understand about the solution!!!
- Basically, we have this formula:
  - sum[i:j] = prefixSum[j] - prefixSum[i-1]
- Let say, we iterate from left to right with index j, calculate the prefix sum
- Then put to HM if existing. For Hashmap, key is the prefixsum, and value is the index (sum up to this index)
- Explain: whenever found key equals (currentSum - k). I understnad k = sum[i,j] above
- => prefixSum[j] - k = prefixSum[i-1]
- calculate the length: j - hm.get(currentSum - k);
- update the max

```java
import java.util.HashMap;

public class MaxSumSubarrayEqualsK {

    public static int maxSumSubarray(int[] nums, int k) {
        // Map to store prefix sums and their indices
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        // Add a base case: prefix sum 0 at index -1
        prefixSumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Update the running sum
            currentSum += nums[i];

            // Check if currentSum - k exists in the map
            if (prefixSumMap.containsKey(currentSum - k)) {
                // Calculate the length of the subarray
                int subarrayLength = i - prefixSumMap.get(currentSum - k);
                maxLength = Math.max(maxLength, subarrayLength);
            }

            // Only add currentSum to the map if it doesn't exist
            // to keep the smallest index for that sum
            hm.putIfAbsent(currentSum,i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        int result = maxSumSubarray(nums, k);
        System.out.println("Maximum length of subarray with sum " + k + " is: " + result);
    }
}

```


### 12/25/2025
- Still struggle a bit
- Still use hashmap, but this time, I use python

```python
class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        prefix = 0
        res = 0
        seen = {0: -1} 
        for num in nums:
            prefix += num
            if prefix -k in seen:
                res = max(res, i - seen[prefix - k])
            if prefix not in seen:
                seen[prefix] = i
        return res

```