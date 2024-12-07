## URL: https://leetcode.com/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=dynamic-programming


## Thinking process
- 12/08/2024
- Unlike the Unique Path, there is obstacle in this problems
- Ideas are very similar
- Create a 2D dp array
- Need to handle the edges: 
  - If there is an obstacle for specific index, the rest in the edge of row and columns are also blocked -> set to 0
  - Otherwise, set to 1
- Loop through all index in the middle, if facing obstacle, set to 0
- Otherwise, the possible unique path is the sum of left and top -> since we only move right and down

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //Handle the edge column
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        
        //Handle the edge row
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
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