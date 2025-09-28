https://leetcode.com/problems/course-schedule-ii/?envType=problem-list-v2&envId=breadth-first-search

# Thought process
- Topological sort using BFS
- Kahn's algorithm
- Build adjacency list and indegree array
- Initialize queue with all nodes with indegree 0
- While queue not empty:
  - Pop node from queue, add to result
  - Decrease indegree of neighbors, if indegree becomes 0, add to queue
-  - If result length == numCourses, return result, else return []
-  TC: O(V + E)
-  SC: O(V + E)


```python
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses

        for a,b in prerequisites:
            adj[b].append(a)
            indegree[a] += 1
        
        q = deque([i for i in range(numCourses) if indegree[i] == 0])
        res = []

        while q:
            node = q.popleft()
            res.append(node)
            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)
        return res if len(res) == numCourses else []
```