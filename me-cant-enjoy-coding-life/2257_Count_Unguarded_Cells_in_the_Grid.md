URL: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/?envType=daily-question&envId=2024-11-21

Idea:
## 11/21/2024
- Initialize a 2D character array map
- Initialize a 2D direction array
- calculate all available square in the map: (m x n)
- need to minus the number of guards and walls
- Mark all current guards and walls on the map[][]
- To make it easy: we starting from each elements from the guards, then moving to 4 directions. If the current index is already 'N'. reduct the count. Otherwise we will mark it as 'N'.