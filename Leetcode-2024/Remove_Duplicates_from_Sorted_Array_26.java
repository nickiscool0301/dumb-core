/*
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
Then return the number of unique elements in nums.
 Hint: use hashmap, but we need to update the nums array to match with the testcase
 can also use set
 */
class Remove_Duplicates_from_Sorted_Array_26 {
  public int removeDuplicates(int[] nums) {
    int res = 0;
    Map<Integer, Integer> resMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if(!resMap.containsKey(nums[i])) {
        resMap.put(nums[i], i);
        nums[res] = nums[i];
        res++;
      }
    }
    return res;
  }
}

