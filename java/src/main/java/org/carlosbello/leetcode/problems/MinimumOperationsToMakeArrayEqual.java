package org.carlosbello.leetcode.problems;

/**
 * 1551. Minimum Operations to Make Array Equal [medium] https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 */
public class MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        return n % 2 == 0
            ? (int)Math.pow(n / 2, 2)
            : n / 2 * (n / 2 + 1);
    }
}
