### URL: https://leetcode.com/problems/subarray-sum-equals-k/description/

### 12/13/2024
- Should have think from Brute Force to understand the problem better

### Brute Force
- Create a prefix sum array with more than one element
-> prefixSum = new int[arr.length + 1]
- Explanation:
  - arr = [1,2,3]
  - prefixArr = [0, 1, 3, 6]
  -> nums[0] + nums[1] + nums[2] (6) = prefixArr[3] - prefixArr[0] 
- sum[start, end] = prefix[end] - prefix[start]
- 2 nested loop: start: 0 -> length - 1, end; start + 1 -> length - 1
- if (prefix[end] - prefix[start] -> count++) then return count


TC: O(N^2), SC: O(N)

-> Optimize using hash map
while traversing the arr to calculate prefix sum, can use map to compare and optimize
For a subarray starting from index i and ending at index j, the sum can be expressed as:

```txt
sum[i…j] = sum[0…j] − sum[0…i−1]
-> sum[0…i−1] = sum[0…j] − k
```
This means: if (sum - k) has been seen before, 
->  there exists a subarray ending at the current index that sums to 𝑘
so if exist, can increase the frequency of key to the value (sum-k)

<details>

<summary>Brute Force</summary>

```java
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
      
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
      
        for (int start = 0; start < sum.length; start++) {
            for (int end = start + 1; end < sum.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
      
        return count;
    }
}
```

</details>



<details>

<summary>Optimized</summary>

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int count = 0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            if(hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```

</details>