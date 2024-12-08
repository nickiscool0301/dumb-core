## URL: https://leetcode.com/problems/two-best-non-overlapping-events/description/?envType=daily-question&envId=2024-12-08

## Topic
- Prority Queue

## Thinking process
- PQ problem
- Sort events based on startTime
- Create a PQ (int[]) contains only the endtime and value
- For each event in events, get the start, end and value
- while the q is not empty and the peek value end time is less than the current start time of the event
- get the current max from the pq.poll[0]
- update the res (res, curr + value from the loop)
- offer new entries to the queue
- return the max

<details>

<summary>Toggle the view solution</summary>

```java
class Solution {
    public int maxTwoEvents(int[][] events) {
        //sort base on startTime
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        //sort base on endtime
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        //store results
        int max = 0;
        //store current sum
        int curr = 0;

        //loop each event and get variable
        for(int[] event: events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];
            
            //For event in pq that has the end time less than current start time of event
            while(!pq.isEmpty() && pq.peek()[0] < start) {
                //update curr max value
                curr = Math.max(curr, pq.poll()[1]);
            }
            max = Math.max(max, curr + value);
            pq.offer(new int[]{end, value});
        }
        return max;
    }
}
```


</details>