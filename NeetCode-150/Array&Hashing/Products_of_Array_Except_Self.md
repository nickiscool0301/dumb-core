URL: https://neetcode.io/problems/products-of-array-discluding-self

```angular2html
Input: nums = [1,2,4,6]
Output: [48,24,12,8]

Input: nums = [-1,0,1,2,3]
Output: [0,-6,0,0,0]
```
## Solution
### 11/22/2024:
- first loop: calculate the total product (except zero), also count number of zero
- If number of zero > 1, return array with all zero
- loop through input arr, if:
  - 0: fill this with total product / current index value
  - Not 0: fill with 0

