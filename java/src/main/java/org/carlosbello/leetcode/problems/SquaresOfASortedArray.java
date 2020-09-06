package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array [easy] https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(a -> a * a).sorted().toArray();
    }
}

