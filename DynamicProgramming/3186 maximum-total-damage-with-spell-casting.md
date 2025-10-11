https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/?envType=daily-question&envId=2025-10-11



# Though process
- Feel like a DP problem: for each i, we decide to take this power and skipp distance of 2, or skip this
- dp[i]: the max total damage using values up to i
  
Each at i:
- Find previous value j: where power[i] - power[j] > 2
- Two choices:
  - skip current: dp[i-1]
  - take: damage[i] + dp[j]
- Question? how to quickly find the index j?
find first index j that vals[j] > vals[i] - 3 -> then j-1 give the last index that <= vals[i] - 3 -> use binary search here to reduce O(N) -> O(logN)

TC: O(N*logN)
SC: O(N)

```python
from collections import Counter
import bisect

class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        count = Counter(power)
        vals = sorted(count)
        damage = [v * count[v] for v in vals]

        dp = [0] * len(vals)
        dp[0] = damage[0]

        for i in range(1, len(vals)):
            j = bisect.bisect_right(vals, vals[i] - 3) - 1
            skip = dp[i-1]
            take = (dp[j] if j >= 0 else 0) + damage[i]
            dp[i] = max(skip,take)
        return dp[-1]
```