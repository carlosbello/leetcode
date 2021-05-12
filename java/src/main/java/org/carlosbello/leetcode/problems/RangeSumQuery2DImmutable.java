package org.carlosbello.leetcode.problems;

/**
 * 304. Range Sum Query 2D - Immutable [medium] https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2DImmutable {
    private int[][] sumMatrix;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for(int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for(int col = 0; col < matrix[0].length; col++) {
                rowSum += matrix[row][col];
                sumMatrix[row + 1][col + 1] = rowSum + sumMatrix[row][col + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int wholeSum = sumMatrix[row2 + 1][col2 + 1];
        int upperSum = sumMatrix[row1][col2 + 1];
        int leftSum = sumMatrix[row2 + 1][col1] - sumMatrix[row1][col1];

        return wholeSum - upperSum - leftSum;
    }
}
