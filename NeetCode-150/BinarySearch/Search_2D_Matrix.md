## URL: https://neetcode.io/problems/search-2d-matrix

## Think process
- Binary search proble, think matrix like an array -> just modify the mid to X and Y coordinate
- **IMPORTANT**
  - x-coordinate = mid / (# of columns on matrix)
  - y-coordinate = mid % (# of columns on matrix)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int right = m*n -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int tempX = mid / n;
            int tempY = mid % n;
            if(matrix[tempX][tempY] == target) {
                return true;
            } else if (matrix[tempX][tempY] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
```