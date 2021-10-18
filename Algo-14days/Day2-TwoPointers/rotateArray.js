// Given an array, rotate the array to the right by k steps, where k is non-negative.

var rotate = function (nums, k) {
  let n = nums.length;
  let tempArr = [...nums];
  let i = 0;
  let j = 0;
  k %= n;

  for (i = n - k; i < n; i++, j++) {
    nums[j] = tempArr[i];
  }

  for (i = 0; i < n - k; i++, j++) {
    nums[j] = tempArr[i];
  }
};

console.log(rotate([1, 2, 3, 4, 5, 6, 7], 3));
