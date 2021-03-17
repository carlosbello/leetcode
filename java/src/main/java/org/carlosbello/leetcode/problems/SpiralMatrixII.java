package org.carlosbello.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 59. Spiral Matrix II [medium] https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        Queue<int[]> directions = new LinkedList<>(List.of(
                new int[] {0, 1},
                new int[] {1, 0},
                new int[] {0, -1},
                new int[] {-1, 0}
        ));
        int count = 1;
        int[][] m = new int[n][n];
        int i = 0;
        int j = 0;
        m[i][j] = count;
        int top = (int)Math.pow(n, 2);
        while (count < top) {
            int[] step = directions.remove();
            while (i + step[0] >= 0 && i + step[0] < n &&
                    j + step[1] >= 0 && j + step[1] < n &&
                    m[i + step[0]][j + step[1]] == 0 && count < top) {
                i += step[0];
                j += step[1];
                m[i][j] = ++count;
            }
            directions.add(step);
        }
        return m;
    }
}
