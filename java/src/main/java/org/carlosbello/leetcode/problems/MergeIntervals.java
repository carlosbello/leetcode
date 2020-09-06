package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 56. Merge Intervals [medium] https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        int[][] overlaps = new int[intervals.length][2];
        int currentOverlaps = 0;


        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        overlaps[0] = intervals[0];

        for (int currentInterval = 1; currentInterval < intervals.length; currentInterval++) {
            if (intervals[currentInterval][0] <= overlaps[currentOverlaps][1]) {
                overlaps[currentOverlaps][1] = Math.max(
                        overlaps[currentOverlaps][1],
                        intervals[currentInterval][1]
                );
            } else {
                currentOverlaps++;
                overlaps[currentOverlaps] = intervals[currentInterval];
            }
        }

        int[][] result = new int[currentOverlaps + 1][2];
        System.arraycopy(overlaps, 0, result, 0, currentOverlaps + 1);

        return result;
    }
}
