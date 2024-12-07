### URL: https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=dynamic-programming

### Thinking process
- 12/08/2024
- Use 2D array dp to keep track of the number of moves
- For a specific index on the matrix, the number of possible unique paths can be from the left or from the top (2 way to move)
- So, the possible paths will be the sum of two ways
- Since we only move right or down -> the edge of matrix should be set the one.


<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];            
                }
            }
        }
        return dp[m-1][n-1];
    }       
}
```

</details>


