## URL: https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming

## Think process
### Top-down approach
- Use dfs but we need a memo (in this case, it is a hashmap to keep track of repeated values)
- Go from top of triangle to the bottom. Need to compare two value:
  - One from i, and other at i+1 -> (row + 1, col) && (row + 1, col + 1)
  - Key of HM is the "row, col"
- TC: O(N^2)
- SC: O(N)

## Bottom-Up approach
- Think in the opposite way, if we start at the bottom, and go to the top, the result will be at dp[0]
- We only need a int[] dp with the size of triangle.size();
- Firstly, add the last row of triangle to dp
- Then start looping from the second bottom row:
  - row = len - 2 -> row >= 0
  - for col = 0 -> col <= row
  - Update the dp[col] = current value of triangle.get(row).get(col) + the max between (dp[col], dp[col+1]) -> think like you look above index at i and i+1
- Return the dp[0]


<details>

<summary>Toggle to view Top-Down solution</summary>

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

<details>

<summary>Toggle to view Top-Down solution</summary>

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }

        for(int row = len - 2; row >= 0; row--) {
            for(int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
            }
        }
        return dp[0];
    }
}
```

</details>