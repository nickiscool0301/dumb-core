## URL: https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75

## Think process
- Using two pointers: from left and right
- Whenever we reach both left and right are vowels -> swap them together
- One of them is vowel -> wait for the others
- return arr to string

```java
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(isVowel(arr[left]) && isVowel(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
                left++;
            } else if(isVowel(arr[left])) {
                right--;
            } else {
                left++;
            }
        }
        return String.valueOf(arr);
    }

    private boolean isVowel(char c) {
        return (c == 'a') || (c == 'A') || (c == 'e') || (c == 'E') || (c == 'i') || (c == 'I') || (c == 'o') || (c == 'O') || (c == 'u') || (c == 'U'); 
    }
}
```