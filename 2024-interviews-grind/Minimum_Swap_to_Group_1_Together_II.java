/*
# 11/23/2024
- Idea: create a sliding window with size of (number of 1 in the array)
- Two pointer left, and right. Move pointer right, if current index is:
    + 1 -> increase the current variable
- if the sliding window size is greater than count -> remove value from curr then move left pointer
- Keep track of the max
- result is count - max
 */
class Solution {
    public int minSwaps(int[] nums) {
        int res = 0;
        int max = 0;
        int curr = 0;
        long count = Arrays.stream(nums).filter(e -> e == 1).count();
        int l = 0;
        for(int r = 0; r < 2*nums.length; r++) {
            if(nums[r % nums.length] == 1) {
                curr++;
            }
            if(r - l + 1 > count) {
                curr -= nums[l % nums.length];
                l++;
            }
            max = Math.max(max, curr);
        }
        return (int) count - max;
    }
}