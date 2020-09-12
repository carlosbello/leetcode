package org.carlosbello.leetcode.problems;

/**
 * 325. Maximum Size Subarray Sum Equals k [medium] https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;

        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int sum = 0;
            for (int i = startIndex; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    max = Math.max(max, i - startIndex + 1);
                }
            }
        }

        return max;
    }
}
