### URL
https://leetcode.com/problems/daily-temperatures/description/?envType=company&envId=sap&favoriteSlug=sap-all

### Solution
- Monotonic Stack:
  - Pattern:
    - Dependency on Previous or Future Values: relationship with previous or future values in an array
    - Need for Efficient Lookups
    - It is good to keep track of index and value while iterate

### 11/29/2024
- Though process
  - Brute force would take O(N^2) which is inefficient
  - Need a DS to keep track for each index -> remove second loop
  - Stack is good here because of Monotonic Stack pattern (next)
  - Steps:
    - loop through array
    - if stack is empty or the current value is not larger then the recent value (peek) from stack -> push this index to the stack
    - Otherwise, pop out the recent value from stack (pop) -> set res[index] = i - res
    - return the result

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                res[index] = i - index;
            }
            s.push(i);
        }
        return res;
    }
}
```
</details>