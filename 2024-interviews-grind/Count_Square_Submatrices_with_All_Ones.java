/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.


Approach: Dynamic programming, use 2D array to store the size of largest square submatrix
 */

class Solution {
  public int countSquares(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    int count = 0;

    //Initizalize first column
    for(int i = 0; i < n; i++) {
      dp[i][0] = matrix[i][0];
      count += dp[i][0];
    }

    //Initizalize first row
    for(int i = 1; i < m; i++) {
      dp[0][i] = matrix[0][i];
      count += dp[0][i];
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j < m; j++) {
        if(matrix[i][j] == 1) {
          dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
        }
        count += dp[i][j];
      }
    }
    return count;
  }
}

