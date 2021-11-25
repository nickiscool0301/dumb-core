// Given two integer arrays nums1 and nums2, return an array of their intersection. 
// Each element in the result must appear as many times as it shows in both arrays 
// and you may return the result in any order.

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

// There are two approaches for this problem: 

// #1: Use Hashmap 
//      1. Use Hashmap to store each number with the frequency in nums1[] 
//      2. Loop through nums2[], if the number is already existed in hashmap, reduce its frenquency and add it to the result

// #2: Sort two arrays then use two pointers approach
//      1. Sort two arrays
//      2. Use two pointers i and j, if nums1[i] == nums2[j] => add that number to result
//      3. If nums1[i] < nums2[j] => increase i by 1. Else increase j by 1     

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Intersection_of_Two_Arrays_350 {
    // 1st method
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int freq = hm.getOrDefault(nums1[i], 0);
            hm.put(nums1[i], freq + 1);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (hm.get(nums2[j]) != null && hm.get(nums2[j]) > 0) {
                list.add(nums2[j]);
                hm.put(nums2[j], hm.get(nums2[j]) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int num = 0; num < list.size(); num++) {
            res[num] = list.get(num);
        }
        return res;
    }

    // 2nd method
    public int[] intersect_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else
                j++;
        }

        int[] res = new int[list.size()];
        for (int num = 0; num < list.size(); num++) {
            res[num] = list.get(num);
        }
        return res;
    }

}