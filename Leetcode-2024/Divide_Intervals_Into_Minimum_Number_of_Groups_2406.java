/*
Only ideas here is using two array start and end
 */

class Solution {
  public int minGroups(int[][] intervals) {
    int l = intervals.length;
    int[] start = new int[l];
    int[] end = new int[l];

    for (int i = 0; i < l; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

    //Sort
    Arrays.sort(start);
    Arrays.sort(end);

    int end_pointer = 0;
    int res = 0;

    // Loop through start
    for(int s : start) {
      if (s > end[end_pointer]) {
        end_pointer++;
      } else {
        res++;
      }
    }
    return res;
  }
}