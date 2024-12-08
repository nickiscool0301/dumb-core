## URL: https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming

## Thinking process
### 12/08/2024
- Instead of starting from the top to bottom, we can choose to start from second row at the bottom for better visualization
- From each row, we calculate the current value of next row (col + 1)
- calculate the left top, and right top -> need to check the condition to avoid index out of bound
- Get the min value from topleft and topright, compare with current value
- Loop through the first row on the matrix -> find the smallest one

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        for(int r = len - 2; r>=0; r--) {
            for(int c = 0; c < len; c++) {
                int value = matrix[r+1][c];
                int downLeft = c > 0 ? matrix[r+1][c-1] : Integer.MAX_VALUE;
                int downRight = c < len - 1 ? matrix[r+1][c+1] : Integer.MAX_VALUE;
                matrix[r][c] += Math.min(value, Math.min(downLeft, downRight));
            }
        }
        int res = Integer.MAX_VALUE;
        for(int c = 0; c < len; c++) {
            res = Math.min(res, matrix[0][c]);
        }
        return res;       
    }
}
```
</details>