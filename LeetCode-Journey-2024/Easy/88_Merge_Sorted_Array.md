## URL: https://leetcode.com/problems/merge-sorted-array/description/

## Thinking process
- can do inline in nums1
- can do one pass only
- need 3 variables to keep track of last index of nums1, nums2, and last elements of nums1
- if nums2[index2] > nums1[index1] -> add nums[index2] to last index in nums1
- keep repeat that

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m -1;
        int index2 = n - 1;
        int totalIndex = m + n -1;
        while(index2 >= 0) {
            if(index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[totalIndex--] = nums1[index1--];
            } else {
                nums1[totalIndex--] = nums2[index2--];
            }
        }
    }
}

```