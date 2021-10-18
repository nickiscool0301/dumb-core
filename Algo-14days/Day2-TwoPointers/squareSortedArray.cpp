/*
Given an integer array nums sorted in non-decreasing order,
 return an array of the squares of each number sorted in non-decreasing order. 
*/
#include <iostream>
#include <vector>
using namespace std;

void rotate(vector<int> &nums, int k)
{
  int n = nums.size();
  vector<int> tmpV = nums;
  int i, j = 0;
  k %= n;

  for (i = n - k; i < n; i++, j++)
    nums[j] = tmpV[i];

  for (i = 0; i < n - k; i++, j++)
    nums[j] = tmpV[i];
}

int main()
{
  vector<int> nums = {1, 2, 3, 4, 5, 6, 7};
  rotate(nums, 3);
  for (auto &num : nums)
  {
    cout << num << " ";
  }
}