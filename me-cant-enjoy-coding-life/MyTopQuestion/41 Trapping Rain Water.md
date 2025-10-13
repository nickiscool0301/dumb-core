https://leetcode.com/problems/trapping-rain-water/description/

# Thought process
- For specific index: the water can trap = min(maxLeft, maxRight) - height[i]

- Instead of buiding array to find maxLeft, maxRight, then find the min -> use Two Pointers
- l,r = 0, len(height) - 1
- then set the maxLeft, maxRight
- if maxLeft < maxRight -> min(maxLeft, maxRight) = maxLeft -> eaisly calculate

```python
class Solution:
    def trap(self, height: List[int]) -> int:
        l, r = 0, len(height)-1
        leftMax,rightMax = height[l], height[r]
        res = 0
        while l < r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
        return res
```
