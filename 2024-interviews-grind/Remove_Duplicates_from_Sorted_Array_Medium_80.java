/*
Given an integer array nums sorted in non-decreasing order,
 remove some duplicates in-place such that each unique
 element appears at most twice.
The relative order of the elements should be kept the same.
Ideas: use two pointer, and a variable to keep track the count
 */

class Remove_Duplicates_from_Sorted_Array_Medium_80 {
  public int removeDuplicates(int[] nums) {
    int res = 1;
    final int THRESHOLD = 2;
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if(nums[i] == nums[i-1]) {
        if(count < THRESHOLD) {
          nums[res++] = nums[i];
        }
        count++;
      } else {
        count = 1;
        nums[res++] = nums[i];
      }
    }
    return res;
  }
}


