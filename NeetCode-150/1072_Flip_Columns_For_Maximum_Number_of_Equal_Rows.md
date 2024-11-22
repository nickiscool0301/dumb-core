URL: https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/description/?envType=daily-question&envId=2024-11-22


Topic: 
- array manipulation
- bit operator
- Hash Map

Solution:
## 11/22/2024
- use Hash Map: Key is the string of array for each row, value if frequency
- Loop through each row:
- Use String builder to build a string for each row
- Check the first character of each row:
  - if 0: do nothing just build the string
  - if 1: use XOR (^) to revert each character (0->1, 1->0)
- Add each String to the build
- Use Collection.max to get the max value from the hashmap

Sample code
```java
class Solution {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    Map<String, Integer> freq = new HashMap<>();
    for(int[] row : matrix) {
      StringBuilder sb = new StringBuilder();
      if(row[0] == 0) {
        for(int num : row) {
          sb.append(num);
        }
      } else {
            for(int num : row) {
              sb.append(num^1);
            }
      }
      freq.put(sb.toString(), freq.getOrDefault(sb.toString(), 0) + 1);
    }
    return Collections.max(freq.values());
    }   
}
```