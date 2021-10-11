/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
class Solution
{
public:
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        unordered_map<int, int> hash;
        vector<int> result;
        for (int i = 0; i < numbers.size(); i++)
        {
            int findNums = target - numbers[i];
            if (hash.find(findNums) != hash.end())
            {
                result.push_back(hash[findNums]);
                result.push_back(i);
                return result;
            }
            hash[numbers[i]] = i;
        }
        return result;
    }
};