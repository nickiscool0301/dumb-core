# Kahn's Algorithm (Topological Sort)

## Key Ideas
- **Purpose**: Find topological ordering of DAG (Directed Acyclic Graph)
- **Core Concept**: Process nodes with 0 in-degree first
- **Use Cases**: Course scheduling, dependency resolution, task ordering

## Algorithm Steps
1. Count in-degrees for all nodes
2. Add all 0 in-degree nodes to queue
3. While queue not empty:
   - Remove node from queue
   - Add to result
   - Decrease in-degree of neighbors
   - If neighbor's in-degree becomes 0, add to queue

## Template
```python
def topological_sort(graph, n):
    in_degree = [0] * n
    for u in range(n):
        for v in graph[u]:
            in_degree[v] += 1

    queue = deque([i for i in range(n) if in_degree[i] == 0])
    result = []

    while queue:
        node = queue.popleft()
        result.append(node)

        for neighbor in graph[node]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)

    return result if len(result) == n else []  # [] if cycle exists
```

## Remember
- **Cycle Detection**: If result length < total nodes, cycle exists
- **Time**: O(V + E), **Space**: O(V)
- **Common Problems**: Course Schedule I/II, Alien Dictionary