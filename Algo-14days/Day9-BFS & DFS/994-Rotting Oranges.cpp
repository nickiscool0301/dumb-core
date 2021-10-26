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

int orangesRotting(vector<vector<int>> &grid)
{
    int n = grid.size();
    int m = grid[0].size();
    vector<vector<int>> res(n, vector<int>(m, -1)); // not visited
    queue<pair<int, int>> queue;
    int count = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 2)
            {
                res[i][j] = 2;
                queue.push({i, j});
            }
            else
                res[i][j] = 0;
        }
    }
    const int dx[] = {0, 0, 1, -1};
    const int dy[] = {1, -1, 0, 0};

    while (!queue.empty())
    {
        pair<int, int> node = queue.front();
        queue.pop();

        for (int t = 0; t < 4; t++)
        {
            pair<int, int> neighbor = {node.first + dx[t], node.second + dy[t]};
            if (isValid(neighbor, n, m) && res[neighbor.first][neighbor.second] == -1)
            {
                res[neighbor.first][neighbor.second] = res[node.first][node.second] - 1;
                queue.push(neighbor);
                count++;
            }
        }
    }
    return count;
}

int main()
{
    vector<vector<int>> s;
    s.push_back({2, 1, 1});
    s.push_back({1, 1, 0});
    s.push_back({0, 1, 1});
    // vector<vector<int>> res = orangesRotting(s);
    // for (auto a : res)
    // {
    //     for (auto t : a)
    //     {
    //         cout << t << ", ";
    //     }
    // }
    int a = orangesRotting(s);
    cout << a << endl;
}