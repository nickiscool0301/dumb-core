// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
// { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
// Finally multiply two array elements then we get the result

var productExceptSelf = function (nums) {
  let s = nums.length;
  let res = [];
  let p = 1;

  for (let i = 0; i < s; i++) {
    res[i] = p;
    p *= nums[i];
  }

  p = 1;
  for (let i = s - 1; i >= 0; i--) {
    res[i] *= p;
    p *= nums[i];
  }
  return res;
};
