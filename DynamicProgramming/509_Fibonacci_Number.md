- Same af Climbing Stairs

=> Use Memoization

```java
class Solution {
    public int fib(int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        return fib(n, hm);
        
    }

    private int fib(int n, Map<Integer, Integer> hm) {
        if(n <= 1) return n;
        if(!hm.containsKey(n)) {
            hm.put(n, fib(n-1, hm) + fib(n-2, hm));
        }
        return hm.get(n);
    }
}
```