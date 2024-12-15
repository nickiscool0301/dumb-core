## URL: https://leetcode.com/problems/maximum-average-pass-ratio/description


## Thinking process
### 12/15/2024:
- My Mistakes:
  - Cannot predict how the passing ratio change for each class
  - IF current ratio is the smallest does not **guarantee** that after adding extra students, it will increase the most


- Solution: Greedy
  - Need to keep track the ratio of increasing **ONE** student to classes each time
  - To keep track of maximum ratio -> use Max HEAP

- Step by Step:
  - Create a maxHeap contains double[] { ratio of adding one student, # pass, # students)
  - first loop through classes array to offer to the heap:
    - initialize by add one student to pass and total then calculate it
  - After that for each extra Students, we pop out the top value, recalculate the ratio by increasing # pass, and # total by 1
  - maxHEAP will keep track of the highest ratio at double[0] no matter which class is
  - Finally, we pop out each value from the maxHeap, calculate the ratio and add to sum
  - return the sum / length

- Note:
  - be careful with mapping between int and double

<details>

<summary>Toggle to view solution</summary>

```java
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        double sum = 0;
        //First initialize to calculate to ratio
        for(int[] tempClass : classes) {
            pq.offer(new double[]{helper(tempClass[0], tempClass[1]), tempClass[0], tempClass[1]});
        }
        //Recalculate ratio after adding extra students
        for(int i = 0; i < extraStudents; i++) {
            double[] temp = pq.poll();
            double pass = temp[1], total = temp[2];
            pq.offer(new double[]{helper(pass + 1, total + 1), pass + 1, total + 1});
        }

        //pop out to calculate the sum
        while(!pq.isEmpty()) {
            double[] temp = pq.poll();
            sum += (double)temp[1] / temp[2];
        }
        return sum / (classes.length);
    }


    private double helper(double pass, double total) {
        return ((double)(pass + 1)/(total+1)) - ((double)(pass/total));
    }
}

```

TC: O(NLogN + KLogN): First loop, N form helper, and logN from adding elements to heap
second loop: for each extra student (K), add to heap (logN) -> klogN

SC: O(N)



</details>