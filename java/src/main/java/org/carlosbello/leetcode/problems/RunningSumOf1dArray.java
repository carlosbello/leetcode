package org.carlosbello.leetcode.problems;

/**
 * 1480. Running Sum of 1d Array [easy] https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int rSum = 0;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            sum[i] = rSum;
        }
        return sum;
    }
}
