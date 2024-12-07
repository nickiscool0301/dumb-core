### URL: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/?envType=daily-question&envId=2024-12-06


### Topic
- Arrays

### Solution
#### 12/07/2024
- Hi today I feel to down :< 
- Create an array (boolean or int) to mark all the banned number from 0 to max(n)
- Reason: primitive array does not support to contains, or index of to quickly check
- Loop through banned array, and mark them true in the arr above
- Loop from 1 -> n, then calculate the sum with the count variable. Break if we exceed the maxSum. Continue when the number is in the arr