/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
*/

const binarySearch = (nums, target) => {
  let left = 0;
  let right = nums.length - 1;
  while (right >= left) {
    let mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] === target) return mid;
    if (nums[mid] > target) right = mid - 1;
    else left = mid + 1;
  }
  return -1;
};

console.log(binarySearch([-1, 0, 3, 5, 9, 12], 9));
