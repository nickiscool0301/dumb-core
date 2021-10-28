import java.util.ArrayList;
// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

// You may return the answer in any order.

// Algorithm: read the template for more information

// Basically, the procedure is picking one number in the list

// Then backstrack it to the next number. Store two of them to the comb
// If the condition is met, put the list comb into the result. 
// Delete the last element in comb, then continue to backtrack

import java.util.List;

class Combinations_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(result, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for (int s : result.get(i)) {
                System.out.print(s);
            }
            System.out.print("], ");
        }
    }
}