/*
Given a sorted array of distinct integers and a target value, 
return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/

const searchInsertPosition = (nums, target) => {
  let left = 0;
  let right = nums.length - 1;
  while (right >= left) {
    let mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] === target) return mid;
    if (nums[mid] > target) right = mid - 1;
    else left = mid + 1;
  }
  return left;
};

console.log(searchInsertPosition([1, 3, 5, 6], 2));
console.log(searchInsertPosition([1, 3, 5, 6], 7));
