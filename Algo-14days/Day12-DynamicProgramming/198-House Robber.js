// You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint
// stopping you from robbing each of them is that adjacent houses have security systems
// connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

//Algorithm: Using Dynamic Programming

var rob = function (nums) {
  //Check special cases
  if (nums.length == 0) return 0;
  if (nums.length == 1) return nums[0];
  if (nums.length == 2) return Math.max(nums[0], nums[1]);
  //Initialize the dp array
  let dp = [];
  //Set the base
  dp[0] = nums[0]; //rob 0 house
  dp[1] = Math.max(nums[0], nums[1]); //rob 1 house, the money will be the maximum between 2 hourse

  //loop through the nums
  for (let i = 2; i < nums.length; i++) {
    //the next value in dp will be the maximum between the previous dp and the sum of money at that index plus the two
    // previous house. Ex: [a,b,c] - dp[2] = max(b, a+c)
    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
  }
  return dp[nums.length - 1];
};

let arr = [2, 1, 1, 2];
console.log(rob(arr));
