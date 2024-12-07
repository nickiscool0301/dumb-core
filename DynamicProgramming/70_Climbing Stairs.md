### URL: https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming


### Solutions
- Let's break to smaller problems: for a specific step, we can reach the current position by n-1 or n-2 level
- The total possible solution will be the sum of solutions at n-1 and n-2

- There are 4 solutions
  - Recursion:

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
```

-> This is inefficient because it repeats a lot of redundant calculations -> need DS to memorize the steps

    - Memoization: use HashMap & Recursion to track

```java
class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        return climbStairs(n, hm);
    }

    private int climbStairs(int n, Map<Integer, Integer> hm) {
        if(n == 0 || n == 1) return 1;
        if(!hm.containsKey(n)) {
            hm.put(n, climbStairs(n - 1, hm) + climbStairs(n - 2, hm));
        }
        return hm.get(n);
    }

}
```

    - Tabulation: use bottom-up approach to solve iteratively 
```java
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```

