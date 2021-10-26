// Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i
// on the current row, you may move to either index i or index i + 1 on the next row.

// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

// Dynamic Programming: Bottom-Up Approach
//  Set dp[] equal to the last row of triangle
//  For each node in the previous row, find the minimum between two adjacent node below + the value of that node
//  Recursively apply this method from bottom to top
//  Return the value

#include <vector>
#include <iostream>

using namespace std;

int minimumTotal(vector<vector<int>> &triangle)
{
    // get the size of triangle. and the size of last row
    int n = triangle.size();
    int m = triangle[n - 1].size();

    // inialize dp[] is the last row in triangle
    vector<int> dp = triangle[n - 1];

    // loop from the row just before the last row, to the 0 index row
    for (int i = n - 2; i >= 0; i--)
    {
        // for each value in that row
        for (int j = 0; j < triangle[i].size(); j++)
        {
            // use the dp[] value from last row, find the min between two adjacent nodes then plus with the current value
            //  in the row, set that back to the dp[]
            dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j];
        }
    }
    // finally at the top of triangle, we only care abput the first element in dp[]
    return dp[0];
}

int main()
{
    vector<vector<int>> triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}; // 1
    cout << minimumTotal(triangle);
}