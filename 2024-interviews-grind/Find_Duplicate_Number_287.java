/*

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Ideas


https://www.youtube.com/watch?v=wjYnzkAhcNk
use slow and fast pointer

due to special condition, this array can be "treated" as an linked-list with a loop
=> can use slow, and fast pointer
1. First, we initialize two pointers, slow and fast, both set to nums[0]. This is the starting point for both pointers, and it's done to set up the conditions for Floyd's cycle detection algorithm.
2. Detect a cycle
In this step, we enter a while loop where the slow pointer moves one step at a time (slow = nums[slow]),
while the fast pointer moves two steps (fast = nums[nums[fast]]).
The loop continues until both pointers meet at some point within the cycle.
Note that this meeting point is not necessarily the duplicate number; it's just a point inside the cycle
3. find the start of cycle
After identifying a meeting point inside the cycle, we reinitialize the slow pointer back to nums[0].
The fast pointer stays at the last meeting point.
 Now, we enter another while loop where both pointers move one step at a time.
 The reason behind this is mathematical: according to Floyd's cycle detection algorithm,
 when both pointers move at the same speed, they will eventually meet at the starting point of the cycle.
 This is the duplicate number we are looking for.
 */

class Solution {
  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while(slow != fast);
    int slow2 = nums[0];
    while(slow != slow2) {
      slow = nums[slow];
      slow2 = nums[slow2];
    }
    return slow;
  }
}
