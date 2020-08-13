package org.carlosbello.leetcode.problems;

/**
 * 560. Subarray Sum Equals K [medium] https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int subarrayCount = 0;

        for (int start = 0; start < nums.length; start++) {
            int currentTotal = 0;
            for (int end = start; end < nums.length; end++) {
                currentTotal += nums[end];
                if (currentTotal == k) {
                    subarrayCount++;
                }
            }
        }

        return subarrayCount;
    }
}
