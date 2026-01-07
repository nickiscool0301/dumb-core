'''
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
'''

from typing import List
from collections import deque


'''
- maintain a decreasing deque
- the front always contains max of the window

- shrink window: when i - dq[0] >= k -> pop from deque
- when add to res: when i >= k - 1
'''

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        res = []

        for i, num in enumerate(nums):
            while dq and nums[dq[-1]] <= num:
                dq.pop()
            dq.append(i)

            # shrink window
            if i - dq[0] >= k:
                dq.popleft()
            # append to res
            if i >= k - 1:
                res.append(nums[dq[0]])

        return res