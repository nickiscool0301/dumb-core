# https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/?envType=daily-question&envId=2026-11-02


from typing import List
class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        def quickSelect(a, b):
            while True:
                if len(a) <= 1:
                    return a[0]
                p = a[random.randrange(len(a))]
                lo = [x for x in a if x < p]
                if b < len(lo):
                    a = lo
                    continue
                hi = [x for x in a if x > p]
                if b >= len(a) - len(hi):
                    b -= len(a) - len(hi)
                    a = hi
                    continue
                return p
        med = quickSelect(nums, len(nums) // 2)
        return sum(abs(x-med) for x in nums)
