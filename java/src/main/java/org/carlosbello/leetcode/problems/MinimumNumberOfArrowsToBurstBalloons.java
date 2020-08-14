package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 452. Minimum Number of Arrows to Burst Balloons [medium] https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public class Pair {
        public int left;
        public int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private List<Pair> buildSortedPairs(int[][] points) {
        List<Pair> sortedPair = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            sortedPair.add(new Pair(points[i][0], points[i][1]));
        }
        sortedPair.sort((p1, p2) -> p1.left - p2.left);
        return sortedPair;
    }

    private Pair intersect(Pair first, Pair second) {
        return (first.right >= second.left)
                ? new Pair(Math.max(first.left, second.left), Math.min(first.right, second.right))
                : null;
    }

    public int findMinArrowShots(int[][] points) {
        List<Pair> sortedPairs = buildSortedPairs(points);
        int currentPairIndex = 0;

        while (currentPairIndex < sortedPairs.size() - 1) {
            Pair intersection = intersect(sortedPairs.get(currentPairIndex), sortedPairs.get(currentPairIndex + 1));
            if (intersection != null) {
                sortedPairs.remove(currentPairIndex + 1);
                sortedPairs.remove(currentPairIndex);
                sortedPairs.add(currentPairIndex, intersection);
            } else {
                currentPairIndex++;
            }
        }

        return sortedPairs.size();
    }
}
