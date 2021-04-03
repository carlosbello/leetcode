package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 1133. Largest Unique Number [easy] https://leetcode.com/problems/largest-unique-number/
 */
public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        if (A.length == 1) return A[0];

        Arrays.sort(A);
        int i = A.length - 1;

        while (i > 0 && (A[i] == A[i - 1] || (i + 1 < A.length) && A[i] == A[i + 1])) {
            i--;
        }

        return i > 0
            ? A[i]
            : (A[0] != A[1]
                ? A[0]
                : -1);
    }
}
