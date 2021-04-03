package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. Count Nice Pairs in an Array [medium] https://leetcode.com/problems/count-nice-pairs-in-an-array/
 */
public class CountNicePairsInAnArray {
    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        long total = 0;
        Map<Integer, Integer> numMinusRevs = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            var sb = new StringBuilder(Integer.toString(nums[i]));
            sb.reverse();
            int rev = Integer.valueOf(sb.toString());
            int numMinusRev = nums[i] - rev;
            numMinusRevs.put(numMinusRev, numMinusRevs.getOrDefault(numMinusRev, 0) + 1);
        }

        for(long count: numMinusRevs.values()) {
            long increment = count * (count - 1) / 2;
            total = (total + increment) % MOD;
        }

        return (int)total;
    }
}
