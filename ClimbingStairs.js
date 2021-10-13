// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Fibonacci recursion

var climbStairs = function (n, memo = {}) {
  if (n in memo) return memo[n];
  if (n === 1 || n === 0) return 1;
  memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
  return memo[n];
};

let s = 4;
console.log(climbStairs(s));
