package org.carlosbello.leetcode.problems;

import java.util.List;

/**
 * 120. Triangle [medium] https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);

        Integer[] minumumOfNextRow = triangle.get(triangle.size() - 1).toArray(new Integer[0]);

        for (int row = triangle.size() - 2; row >= 0; row--) {
            Integer[] nextMinimum = new Integer[triangle.get(row).size()];
            for (int cell = 0; cell < triangle.get(row).size(); cell++) {
                nextMinimum[cell] = triangle.get(row).get(cell) +
                    Math.min(minumumOfNextRow[cell], minumumOfNextRow[cell + 1]);
            }
            minumumOfNextRow = nextMinimum;
        }

        return minumumOfNextRow[0];
    }
}
