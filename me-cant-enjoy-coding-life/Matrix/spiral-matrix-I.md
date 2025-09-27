https://leetcode.com/problems/spiral-matrix/description/


# Thinking process
## 2025/09/27
- There are two solutions1
### dfs with visited set
- Have an array of directions: make sure to move right, down, left, up
- key ideas here is we have defines 3 variables: c,r,d
  - c: current column
  - r: current row
  - d: direction
- loop from 0 -> ROWS * COLS
- for each r,c - we check the validity and move them based on the direction
TC: O(M*N)
SC: O(M*N) - visited set

```python
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        res = []
        ROWS, COLS = len(matrix), len(matrix[0])
        visited = set()
        dir = [(0,1),(1,0),(0,-1),(-1,0)]
        r,c,d = 0,0,0
    
        for _ in range(ROWS*COLS):
            res.append(matrix[r][c])
            visited.add((r,c))

            nr,nc = r + dir[d][0], c + dir[d][1]

            if not ((nr,nc) not in visited and 0 <= nr < ROWS and 0 <= nc < COLS):
                d = (d+1)%4
                nr,nc = r + dir[d][0], c + dir[d][1]
            r,c = nr, nc
        return res
```


### Using 4 variables: top, bottom, left, right
- This can get rid of visited set
- Loop while left <= right and top <= bottom
  - move right first
  - move down
  - move left
  - move up
- update the 4 variables accordingly
TC: O(M*N)
SC: O(1)


```python
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        res = []
        ROWS, COLS = len(matrix), len(matrix[0])
        top,bottom = 0, ROWS - 1
        left, right = 0, COLS - 1

        while top <= bottom and left <= right:
            # move right first
            for c in range(left,right+1):
                res.append(matrix[top][c])
            top += 1

            # move bottom
            for r in range(top, bottom + 1):
                res.append(matrix[r][right])
            right -= 1

            # move left
            if top <= bottom:
                for c in range(right, left-1,-1):
                    res.append(matrix[bottom][c])
                bottom -= 1

            # move top
            if left <= right:
                for r in range(bottom, top - 1, -1):
                    res.append(matrix[r][left])
                left += 1
        return res
```