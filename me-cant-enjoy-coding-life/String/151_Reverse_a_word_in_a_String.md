<!-- 151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces. -->

Think process

- CAN do in ONE pass
- when reverse the string, can have two pointers to keep track of the start and end of the word
- left, right pointer = string.length - 1. Then if the left pointer equals ' ', set the right = left which means starting a new word in a string
- if we face the left = 0 or the next index left - 1 is ' ' -> it is time to finish this current word
  - need to check if the current Stringbuilder is empty (size 0), then append the ' '
  - then append the substring of string s from 2 pointers: left and right

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int r = s.length();
        for(int l = s.length() - 1; l >= 0; l--) {
            if(s.charAt(l) == ' ') {
                r = l;
            } else if (l == 0 || s.charAt(l - 1) == ' ') {
                if(sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s.substring(l, r));
            }
        }
        return sb.toString();

    }
}
```
