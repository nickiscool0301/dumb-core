// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// use two pointer: slow, fast. Loop fast pointer first, when reaching non-zero numbers, update it to index slow.
// then loop from slow to the end of vector, update value of each index to zero
#include <iostream>
#include <vector>
using namespace std;
void moveZeroes(vector<int> &nums)
{
    int slow = 0;
    int fast = 0;
    while (fast < nums.size())
    {
        if (nums[fast] != 0)
        {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    while (slow < nums.size())
    {
        nums[slow] = 0;
        slow++;
    }
}

int main()
{
    vector<int> nums = {1, 2, 0, 0, 3, 4, 0, 5, 1, 12};
    moveZeroes(nums);
    for (auto &num : nums)
    {
        cout << num << " ";
    }
}