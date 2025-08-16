## URL: https://leetcode.com/problems/continuous-subarrays/description/?envType=daily-question&envId=2024-12-14

## Thinking process
- Two pointers: left - right

### Brute Force
- 2 loop: left and right
- When moving right, get the max, and min between `nums[left]` and `nums[right]`
- if not violate the condition, increases the count
- return the count
- TC: O(N^2), SC: O(1)

### Optimize tips
- Need a better way to retieve the max and min easily with DS
- Some DS supporting this: TreeMap, PriorityQueue, DeQueue



### TreeMap
- TreeMap <number, frequency>:
    - can get the lastEntry() as a max
    - can get the firstEntry() as a min
    - when moving right, add to the treemap, check the violation condition.
        - if violate, need to remove the nums[left] by decrease the freq by 1 or remove (if freq reaches 0)
- TC: O(Nlogk), SC: O(N)

<details>

<summary>TreeMap solution</summary>

```java
class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int left = 0, right = 0;
        long res = 0;
        while(right < nums.length) {
            tm.put(nums[right], tm.getOrDefault(nums[right], 0) + 1);
            while(tm.lastEntry().getKey() - tm.firstEntry().getKey() > 2) {
                tm.put(nums[left], tm.get(nums[left]) - 1);
                if(tm.get(nums[left]) == 0) {
                    tm.remove(nums[left]);
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
```

</details>


### PriorityQueue:
  - two pq: minHeap and maxHeap
  - when moving right, add index right to 2 pq
  - while(left < right && violate)
    - move the left pointers
    - poll out all the value less than left
  - count = right - left + 1

<details>

<summary>PriorityQueue solution</summary>

```java
class Solution {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (nums[b] - nums[a]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (nums[a] - nums[b]));
        int left = 0;
        long res = 0;
        for(int right = 0; right < nums.length; right++) {
            maxHeap.offer(right);
            minHeap.offer(right);
            while(left < right && nums[maxHeap.peek()] - nums[minHeap.peek()] > 2) {
                left++;
                while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek() < left) {
                    minHeap.poll();
                }
            }
            res += right - left + 1;
        }
        return res;
    }
}
```

</details>


### Dequeue: (to be continue)