## URL: https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75

## Thinking process
### 12/08/2024
- Can place flowers if current index is 0, and index - 1 , index + 1 also are 0 -> check edge case at index 0 and the last index
- Loop through array, set the value to 1 -> reduce the number of flower. If reach 0 -> return true
- return false

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0) return true;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == len -1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
            }
        }
        return false;

    }
}
```
</details>