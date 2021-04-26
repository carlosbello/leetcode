package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1642. Furthest Building You Can Reach [medium] https://leetcode.com/problems/furthest-building-you-can-reach/
 */
public class FurthestBuildingYouCanReach {

    /**
     * Accepted solution.
     *
     * The idea was to use ladders in the highest jumps filling with bricks the smaller ones.
     * For doing so, we'll always use a ladders if we can and, once we found a new building that
     * is bigger than the smaller building with a ladder, we replace the ladder with bricks and
     * use the ladder in the new building.
     * If we can't replace the ladder with bricks (because the smaller building with a ladder is bigger
     * than the amount of available bricks) we can't continue advancing and that's the furthest we can reach.
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        var biggestJumps = new PriorityQueue<Integer>(Integer::compare);

        int current = 0;
        for (; current < heights.length - 1; current++) {
            var jumpSizeFromCurrent = jumpSizeFrom(current, heights);
            if (jumpSizeFromCurrent <= 0) continue;
            if (ladders > 0) {
                biggestJumps.add(jumpSizeFromCurrent);
                ladders--;
            } else {
                if (!biggestJumps.isEmpty() && biggestJumps.peek() < jumpSizeFromCurrent && biggestJumps.peek() <= bricks) {
                    bricks -= biggestJumps.poll();
                    biggestJumps.add(jumpSizeFromCurrent);
                } else if (jumpSizeFromCurrent <= bricks) {
                    bricks -= jumpSizeFromCurrent;
                } else {
                    break;
                }
            }
        }

        return current;
    }

    public int jumpSizeFrom(Integer current, int[] heights) {
        return current == null
            ? Integer.MAX_VALUE
            : heights[current + 1] - heights[current];
    }

    /**
     * Valid solution but gets "Time Limit Exceeded"
     *
     * The idea was use DP with a DFS + memoization to find the solution
     */
    public int furthestBuilding1(int[] heights, int bricks, int ladders) {
        var solutions = new HashMap<List<Integer>, Integer>();
        return furthest(0, bricks, ladders, heights, solutions);
    }

    private int furthest(int from, int bricks, int ladders, int[] heights, Map<List<Integer>, Integer> solutions) {
        var currentCase = List.of(from, bricks, ladders);
        if (from >= heights.length - 1) return 0;
        if (solutions.containsKey(currentCase)) return solutions.get(currentCase);

        var differenceToNextBuilding = heights[from + 1] - heights[from];

        var jumping = differenceToNextBuilding <= 0
            ? 1 + furthest(from + 1, bricks, ladders, heights, solutions)
            : 0;
        var usingALadder = differenceToNextBuilding > 0 && ladders > 0
            ? 1 + furthest(from + 1, bricks, ladders - 1, heights, solutions)
            : 0;
        var usingBricks = differenceToNextBuilding > 0 && bricks >= differenceToNextBuilding
            ? 1 + furthest(from + 1, bricks - differenceToNextBuilding, ladders, heights, solutions)
            : 0;

        var solution = Math.max(jumping, Math.max(usingALadder, usingBricks));
        solutions.put(currentCase, solution);

        return solution;
    }
}
