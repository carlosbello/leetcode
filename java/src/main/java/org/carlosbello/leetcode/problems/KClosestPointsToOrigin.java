package org.carlosbello.leetcode.problems;

import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin [medium] https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    private double distanceToCenter(int[] p) {
        return Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] pointList = new int[k][2];
        PriorityQueue<int[]> sortedPointsByDistance = new PriorityQueue<>(
                (p1, p2) -> Double.compare(distanceToCenter(p1), distanceToCenter(p2))
        );

        for (int[] pair: points) {
            sortedPointsByDistance.add(pair);
        }

        for (int i = 0; i < k; i++) {
            pointList[i] = sortedPointsByDistance.poll();
        }

        return pointList;
    }
}
