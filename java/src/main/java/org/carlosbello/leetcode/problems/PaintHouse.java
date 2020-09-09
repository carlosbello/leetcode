package org.carlosbello.leetcode.problems;

/**
 * 256. Paint House [easy] https://leetcode.com/problems/paint-house/
 */
public class PaintHouse {
    private int[][] minCosts;

    private int minCost(int[][] costs, int startingIndex, int excludingColor) {
        if (startingIndex >= costs.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int color = 0; color < 3; color++) {
            if (color == excludingColor) continue;

            if (minCosts[startingIndex][color] == -1) {
                minCosts[startingIndex][color] = costs[startingIndex][color] + minCost(costs, startingIndex + 1, color);
            }
            min = Math.min(min, minCosts[startingIndex][color]);
        }
        return min;
    }

    public int minCost(int[][] costs) {
        minCosts = new int[costs.length][3];
        for (int[] c: minCosts) {
            c[0] = c[1] = c[2] = -1;
        }

        return minCost(costs, 0, -1);
    }
}
