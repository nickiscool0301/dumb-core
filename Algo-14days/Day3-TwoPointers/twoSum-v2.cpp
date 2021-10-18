/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.

Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
*/

// Use Two pointer technique: one at the beginning and one at the end -> calculate the sum
// -> if sum < target: begin++, if sum > target: end--, else return {begin++, end++}

#include <iostream>
#include <vector>
using namespace std;

vector<int> twoSum(vector<int> &numbers, int target)
{
    int begin = 0;
    int end = numbers.size() - 1;
    while (begin < end)
    {
        int sum = numbers[begin] + numbers[end];
        if (sum > target)
            end--;
        else if (sum < target)
            begin++;
        else
            return {begin + 1, end + 1};
    }
    return {};
}

int main()
{
    vector<int> numbers = {2, 7, 11, 15};
    vector<int> result = twoSum(numbers, 22);
    for (auto &num : result)
    {
        cout << num << " ";
    }
}