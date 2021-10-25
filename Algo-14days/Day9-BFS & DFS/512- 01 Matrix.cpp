// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two adjacent cells is 1.

// Input : mat = [ [ 0, 0, 0 ], [ 0, 1, 0 ], [ 0, 0, 0 ] ]
// Output : [ [ 0, 0, 0 ], [ 0, 1, 0 ], [ 0, 0, 0 ] ]

// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

/*
Algorithm:
1. Initialize a new vector dict<> with all values is -1 (not visited) with same size as the input vector
2. Initialize a queue to store the "0" cell to perform BFS later
3. Loop through input vector, if the value of cell is 0, set to 0 in dict<> and push that into queue
4. Repeat
    . Get the front value from queue, then pop the queue
    . For each neighbor node (total 4):
        + If that neighbor can also has other four neightbors or it is not visited yet:
            ~ Add 1 to the dict[][] of that neightbor
            ~ Push that neighbor into a queue to perform the BFS later
5. Return the dict matrix
*/

#include <vector>
#include <queue>
#include <iostream>

using namespace std;

bool isValid(pair<int, int> cell, int n, int m)
{
    if (cell.first < 0 || cell.second < 0 || cell.first >= n || cell.second >= m)
    {
        return false;
    }
    return true;
}

vector<vector<int>> updateMatrix(vector<vector<int>> &mat)
{
    int n = mat.size();
    int m = mat[0].size();
    vector<vector<int>> dict(n, vector<int>(m, -1));
    queue<pair<int, int>> queue;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (mat[i][j] == 0)
            {
                dict[i][j] = 0;
                queue.push({i, j});
            }
        }
    }

    const int dx[] = {1, -1, 0, 0};
    const int dy[] = {0, 0, 1, -1};

    while (!queue.empty())
    {
        pair<int, int> node = queue.front();
        queue.pop();
        for (int t = 0; t < 4; t++)
        {
            pair<int, int> neighbor = {node.first + dx[t], node.second + dy[t]};
            if (isValid(neighbor, n, m) && dict[neighbor.first][neighbor.second] == -1)
            {
                dict[neighbor.first][neighbor.second] = dict[node.first][node.second] + 1;
                queue.push(neighbor);
            }
        }
    }
    return dict;
}

int main()
{
    vector<vector<int>> s;
    s.push_back({0, 0, 0});
    s.push_back({0, 1, 0});
    s.push_back({1, 1, 1});

    vector<vector<int>> res = updateMatrix(s);
    for (auto a : res)
    {
        for (auto t : a)
        {
            cout << t << ", ";
        }
    }
}