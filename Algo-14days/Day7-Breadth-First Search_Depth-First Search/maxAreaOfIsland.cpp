/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected
4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Ex: Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
                   [0,0,0,0,0,0,0,1,1,1,0,0,0],
                   [0,1,1,0,1,0,0,0,0,0,0,0,0],
                   [0,1,0,0,1,1,0,0,1,0,1,0,0],
                   [0,1,0,0,1,1,0,0,1,1,1,0,0],
                   [0,0,0,0,0,0,0,0,0,0,1,0,0],
                   [0,0,0,0,0,0,0,1,1,1,0,0,0],
                   [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6. at grid[3][8]. There are 6 number 1 4- directionally
Explanation: The answer is not 11, because the island must be connected 4-directionally.
*/

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Solution
{
public:
    int maxAreaOfIsland(vector<vector<int>> &grid)
    {
        int maxArea = 0;

        // declare the number of rows and columns
        int row = grid.size();
        int column = grid[0].size();

        // initialize the vector seen to check if the element is visited or not
        vector<vector<bool>> seen(row, vector<bool>(column, false));

        // loop through each element in row and column
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                maxArea = max(maxArea, calArea(grid, seen, i, j)); // update the max value
            }
        }
        return maxArea;
    }

    // calculate the total area in 4-directional island
    int calArea(vector<vector<int>> &grid, vector<vector<bool>> &seen, int row, int column)
    {
        // check the bound: outside the grid, more than the grid, if the element is already visited or the value is 0
        if (row < 0 || row >= grid.size() || column < 0 || column >= grid[0].size() || seen[row][column] || grid[row][column] == 0)
        {
            return 0;
        }

        // set the value is visited
        seen[row][column] = true;

        // use recursion to calculate the total area of island in 4-directional position
        return (1 + calArea(grid, seen, row + 1, column) + calArea(grid, seen, row - 1, column) +
                calArea(grid, seen, row, column + 1) + calArea(grid, seen, row, column - 1));
    }
};

int main()
{
    vector<vector<int>> grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    Solution s;
    cout << s.maxAreaOfIsland(grid);
}