/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
 */


/*
Idea: loop through all array, check if count is 0, set the current one to majority num, then for each element equal to
that value, increases the count, otherwise, decrease it
 */
class Solution {
  public int majorityElement(int[] nums) {
    int s = nums.length;
    int majorNum = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) majorNum = nums[i];
      if (majorNum == nums[i]) count++;
      else count--;
    }
    return majorNum;
  }
}