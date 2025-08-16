## URL: https://leetcode.com/problems/valid-palindrome-ii/description/


## Think process
- Also use two pointer
- When face `s.charAt(left) != s.charAt(right)`, we can remove one character -> could be left or right
- write helper function to check validation of palindrome then apply for left and right


```java
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                if(validSubPalindrome(s, left + 1, right)) return true;
                return validSubPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
        
    }

    private boolean validSubPalindrome(String s, int left, int right) {
        int n = right - left + 1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
```