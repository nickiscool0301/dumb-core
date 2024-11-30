### URL: https://leetcode.com/problems/next-greater-element-i/description/
### Solution
- Monotonic Stack


### Thinking Process
### 30/11/2024
- Brute force will take O(N^2) -> to avoid the second loop on num2 -> use Map + Stack
- Map will contain the current num and the next larger value
- Stack will keep track of the current value, and then comparing with the next large index (num)
- Code:
  - Stack, Map
  - For each num in num2
    - while(stack is not empty and num > stack.peek()) (peek here is the value of previous value, since we want to find **NEXT LARGER** number)
    - put key = stack.pop, and value is num
    - s.push(num)
  - Need to build a res arr, for each num in num1, just take value from the hash map (default value is -1)
  - return res

<details>

<summary>Toggle to view code solution</summary>

```java 
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hm = new HashMap<>();

        for(int num : nums2) {
            while(!stack.isEmpty() && num > stack.peek()) {
                hm.put(stack.pop(), num);
            }
            stack.add(num);
        }

        int i = 0;
        for(int num : nums1) {
		    ans[i++] = hm.getOrDefault(num, -1);
	    }
        return ans;
    }
}
```


</details>