https://leetcode.com/problems/diagonal-traverse/

# Thought process
## 2025/09/27
- Key to remember:
  - Total diagonals = ROWS + COLS - 1
  - For each diagonal, we can determine the starting point (r,c)
  - If d < COLS: r,c = 0,d
  - else: r,c = d-COLS+1,COLS - 1
  - For each cell (r,c). r + c = d. This proves that all of cobinations of (r,c) that r + c = d will belong the same diagonal

- Loop through each diagonal:
- Define the cell with r,c then loop while r < ROWS and c >= 0
- Add the temp list then add to result based on the diagonal number is odd or even

```python
class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        if not mat: return []
        ROWS, COLS = len(mat), len(mat[0])
        res = []

        for d in range(ROWS + COLS - 1):
            temp = []
            if d < COLS:
                r,c = 0,d
            else:
                r,c = d-COLS+1,COLS - 1
            while r < ROWS and c >= 0:
                temp.append(mat[r][c])
                r += 1
                c -= 1
            if d & 1 == 1:
                res.extend(temp)
            else:
                res.extend(reversed(temp))
        return res
```