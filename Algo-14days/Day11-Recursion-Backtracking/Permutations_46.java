// Given an array nums of distinct integers, 
// return all the possible permutations. You can return the answer in any order.

import java.util.ArrayList;
import java.util.List;

class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> comb, int[] nums) {
        if (comb.size() == nums.length) {
            result.add(new ArrayList<>(comb));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!comb.contains(nums[i])) {
                    comb.add(nums[i]);
                    backtrack(result, comb, nums);
                    comb.remove(comb.size() - 1);
                }
            }
        }

    }
}