package org.carlosbello.leetcode.problems;

/**
 * 48. Rotate Image [medium] https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length - 1;
        for (int s = 0, e = matrix[0].length - 1; s < e; s++, e--) {
            for (int i = 0; s + i < e; i++) {
                int t = matrix[s + i][e];
                matrix[s + i][e] = matrix[s][s + i];
                matrix[s][s + i] = matrix[m - s - i][s];
                matrix[m - s - i][s] = matrix[m - s][e - i];
                matrix[m - s][e - i] = t;
            }
        }
    }
}
