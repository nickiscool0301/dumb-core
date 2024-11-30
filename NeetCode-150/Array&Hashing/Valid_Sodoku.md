### URL: https://neetcode.io/problems/valid-sudoku

### Solution
- HashMap
- HashSet

### Think process
- 11/30/2024
  - We don't care about the logic of this problems, we just need to make sure if it is a valid Soduku by using HashSet and HashMap to check the duplicate values in the board
  - Use 3 hashmap
    - rows: Integer, Set<>
    - cols: Integer, Set<>
    - squares: square is special -> String, Set<>
  - Observations:
    - To check the duplicate in the squares, the approach is to take the r/3 and c/3
    - use String as a key
  - Trick: use computeIfAbsent of HashMap to quickly check the existent of key (r, c, squareKey). Otherwise, create a new HashSet
  - get index and append to each hashset

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') {
                    continue;
                }
                String squareStr = (r / 3) + "," + (c / 3);
                if( (rows.computeIfAbsent(r, k -> new HashSet()).contains(board[r][c]))
                 || (cols.computeIfAbsent(c, k -> new HashSet()).contains(board[r][c]))
                 || (squares.computeIfAbsent(squareStr, k -> new HashSet()).contains(board[r][c]))
                ) {
                    return false;
                }


                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareStr).add(board[r][c]);
            }
        }
        return true;
    }
}
```

</details>