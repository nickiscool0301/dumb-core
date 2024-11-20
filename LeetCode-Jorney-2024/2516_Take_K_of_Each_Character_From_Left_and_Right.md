URL: https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-11-20

Some solutions:
- Backtracking + DP
- Sliding window

Explain:
## 11/20/2024: 

I solved using sliding window. First we need to count all number of letter 'a', 'b', 'c'. Then we initialize left and right pointer at index 0.
When the right pointer move from left the right, I decreased the count for that character by 1. There are 2 situations here:
- The remaining part of array is still valid (contains at least k): just keep updating the res variable
- If it is not valid anymore, it is time to move the left pointer with the *WHILE LOOP*, for each index we increase the count for each character again
  
  
