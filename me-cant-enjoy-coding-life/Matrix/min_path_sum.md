https://leetcode.com/problems/minimum-path-sum/description/

# Though process
- Idea is very similar to Unique Paths I and II
- Use DP to store the min path sum to reach each cell
- DP formula:
- dp[r][c] = grid[r][c] + min(dp[r-1][c], dp[r][c-1])
- can use 1D array to optimize space

```python
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        ROWS,COLS = len(grid), len(grid[0])
        dp = [0] * COLS
        dp[0] = grid[0][0]

        for j in range(1,COLS):
            dp[j] = grid[0][j] + dp[j-1]
        
        for i in range(1,ROWS):
            dp[0] += grid[i][0]
            for j in range(1,COLS):
                dp[j] = grid[i][j] + min(dp[j],dp[j-1])
        return dp[COLS-1]
```
TC: O(M*N)
SC: O(N)
