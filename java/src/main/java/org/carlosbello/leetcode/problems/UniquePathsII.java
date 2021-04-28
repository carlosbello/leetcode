package org.carlosbello.leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 63. Unique Paths II [medium] https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Deque<int[]> toVisit = new LinkedList<>();

        if (obstacleGrid[0][0] == 0) {
            toVisit.add(new int[] {0, 0});
            obstacleGrid[0][0] = -1;
        }

        while (!toVisit.isEmpty()) {
            int[] visiting = toVisit.remove();
            int row = visiting[0];
            int col = visiting[1];
            int currentValue = obstacleGrid[row][col];
            if (row + 1 < m && obstacleGrid[row + 1][col] <= 0) {
                if (obstacleGrid[row + 1][col] == 0) {
                    toVisit.add(new int[] {row + 1, col});
                }
                obstacleGrid[row + 1][col] += currentValue;
            }
            if (col + 1 < n && obstacleGrid[row][col + 1] <= 0) {
                if (obstacleGrid[row][col + 1] == 0) {
                    toVisit.add(new int[] {row, col + 1});
                }
                obstacleGrid[row][col + 1] += currentValue;
            }
        }
        return obstacleGrid[m - 1][n - 1] < 0 ? -obstacleGrid[m - 1][n - 1] : 0;
    }
}
