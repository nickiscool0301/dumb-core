## URL: https://leetcode.com/problems/find-champion-ii/description/?envType=daily-question&envId=2024-11-26

## Solution
### 26/11/2024
- Should visualize a graph to understand the solutions better

Eg: [[0,2],[1,3],[1,2]]
0 -> 2
     ^
     1 -> 3
- For each vertices: we only need to care about winner
- Create an aray for results, and set all loser index to false
- Then loop from 0 -> n, if reach the true, set the winner to that index, also count # of winder
- We only have 1 champion, when count > 1 -> return -1. Otherwise, return the winner

<details>

<summary>Click to view code solution</summary>

```java
class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] result = new boolean[n];
        Arrays.fill(result, true);
        int res = -1;
        int count = 0;
        for(int[] edge : edges) {
            int winner = edge[0];
            int loser = edge[1];
            result[loser] = false;
        }
        for(int i = 0; i < n; i++) {
            if(result[i]) {
                res = i;
                count++;
            }
        }
        return count > 1 ? -1 : res;
    }
}
```
</details>