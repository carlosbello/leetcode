package org.carlosbello.leetcode.problems;

/**
 * 1228. Missing Number In Arithmetic Progression [easy] https://leetcode.com/problems/missing-number-in-arithmetic-progression/
 */
public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int step = (arr[n - 1] - arr[0]) / n;
        int i = 1;

        while (i < n && arr[i] == arr[i-1] + step) {
            i++;
        }

        return arr[i-1] + step;
    }
}
