package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum [easy] https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (indexByNum.containsKey(compliment)) {
                return new int[] {i, indexByNum.get(compliment)};
            } else {
                indexByNum.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
