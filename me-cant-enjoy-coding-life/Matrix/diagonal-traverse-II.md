https://leetcode.com/problems/diagonal-traverse-ii/submissions/1784039421/


## Thought process
- Similar to Diagonal Traverse I
- There are two solutions

### First solution
- Use map to map the key (d = r + c), to a list of all cells that belong to the same diagonal
- Loop through the map, from 0 to the max key, then append the reverse of the list value to the result

```python
class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        diagonals = defaultdict(list)
        
        for r in range(len(nums)):
            for c in range(len(nums[r])):
                diagonals[r+c].append(nums[r][c])
        
        res = []
        for d in range(max(diagonals.keys()) + 1):
            res.extend(reversed(diagonals[d]))
        return res
```
TC: O(N*M)
SC: O(M*N)

### Second solution
- BFS from top left cell
- Use queue to keep track of cell, the cell can only move down or right. Make sure to append the down first, then right becasue the question want to print the cell at col = 0 first
- How to enqueue:
  - if c == 0 and r + 1 < len(matrix): enqueue the down cell
  - if c + 1 < len(matrix[r]): enqueue the right cell


```python
class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        q = deque([[0,0]
        ])
        res = []
        N = len(nums)

        while q:
            r,c = q.popleft()
            res.append(nums[r][c])
            if c == 0 and r + 1 < N:
                q.append([r+1,c])
            if c + 1 < len(nums[r]):
                q.append([r,c+1])
        return res
```