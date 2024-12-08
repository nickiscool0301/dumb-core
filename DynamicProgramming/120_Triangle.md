## URL: https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming

## Think process
### Top-down approach

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> hm = new HashMap<>();
        return dfs(triangle, 0,0, hm);
        
    }

    private int dfs(List<List<Integer>> triangle, int row, int col, Map<String, Integer> hm) {
        if(row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        String str = row + ", " + col;
        if (hm.containsKey(str)) {
            return hm.get(str);
        }
        int left = dfs(triangle, row+1, col, hm);
        int right = dfs(triangle, row+1, col+1, hm);
        int value = triangle.get(row).get(col) + Math.min(left, right);
        hm.put(str, value);
        return value;
    }
}
```

</details>