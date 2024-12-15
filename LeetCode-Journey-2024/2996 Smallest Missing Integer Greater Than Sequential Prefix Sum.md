## URL: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/


## Thinking process
- first initialize the sum is first num in nums
- loop 1 -> end of nums, append the num to the sum
- if found the non-continuous value, break the loop
- Create a set of num
- while true, if we not found the num inside the set -> return the sum. Otherwise sum++



```java
class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        Set<Integer> s = new HashSet<>();
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1] + 1) break;
            sum += nums[i];
        }
        for(int num : nums) {
            s.add(num);
        }
        while(true) {
            if(!s.contains(sum)) return sum;
            sum++;
        }
                
    }
}
```