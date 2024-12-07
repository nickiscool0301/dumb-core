## URL: https://leetcode.com/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming

## Thinking process
- The idea is very similar to the problem Unique Paths
- We can modify the grid array in-line 
- Calculate the prefix sum for all the edges (rows and columns)
- Then for all the index in the middle, the sum will be the min from the left, and the top
- Return the grid[m-1][n-1]

<details>

<summary>Toggle to view solutions</summary>

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 1; i < m; i++) grid[i][0] += grid[i-1][0];
        for(int i = 1; i < n; i++) grid[0][i] += grid[0][i-1];
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
```
</details>