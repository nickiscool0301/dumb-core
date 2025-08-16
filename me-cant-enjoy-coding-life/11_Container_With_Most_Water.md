## URL: https://leetcode.com/problems/container-with-most-water/description/

## Topic
- Two pointers

## Thinking process
- To maximum the area, just try to maximum the width and height
- Maximize the width: left and right pointer = one at begin, one at the end
- for height. Pick the smaller value between left and right. Move the pointer when height of which is smaller

<details> 

<summary>Toggle to view solutions</summary>

```java
class Solution {
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int width = right - left;
            int currHeight = Math.min(height[left], height[right]);
            res = Math.max(res, width * currHeight);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
```

</details>