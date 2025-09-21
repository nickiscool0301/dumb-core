https://leetcode.com/problems/insert-interval/

# Thought process
1. Binary search
- Can use binary search to find the first True (first index in interval where f(x) >= newInterval[0])
- Then insert new interval and merge as needed.
- use while loop for merge later
TC: O(N)
SC: O(N) 


2. Greedy
- process one by one
- Non-overlap before:
  - if current interval ends before newInterval starts, add to result
- Non-overlap after:
  - if current interval starts after newInterval ends, it is completely on the right -> add newInterval to res, and add the res. we are done
- Overlap
  - merge by updating the newInterval then keep going

