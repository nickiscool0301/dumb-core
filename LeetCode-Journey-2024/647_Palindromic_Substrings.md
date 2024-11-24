## URL: https://leetcode.com/problems/palindromic-substrings/description/

## Topic:
- String

## Solution
### 11/24/2024
- We have two type of palindrome: odd and even length
- Example:
  - odd: we start at the center i, we go left i - 1, we go right i + 1
  - even: we start at the center i and i + 1
- Write a count palindrome function
- for each char in string, calculate odd, and even count palindrome
- Dont forget to add 1 for the current value

<details>

<summary>Click to view code solution</summary>

```java
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            int odd = countPalindrome(s, i - 1, i + 1);
            int even = countPalindrome(s, i, i + 1);
            res += odd + even + 1;
        }
        return res;
    }

    private int countPalindrome(String s, int left, int right) {
        int res = 0;
        int len = s.length();
        while(left >= 0 && right < len && s.charAt(left--) == s.charAt(right++)) {
            res++;
        }
        return res;
    }
}
```
</details>
