package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall [medium] https://leetcode.com/problems/brick-wall/
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int rowCount = wall.size();
        int maxNumOfBricksAligned = 0;
        Map<Integer, Integer> bricksAlignedToSize = new HashMap<>();

        for (var row: wall) {
            int accumulatedSize = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                var brickLenght = row.get(i);
                accumulatedSize += brickLenght;
                int bricksCount = bricksAlignedToSize.getOrDefault(accumulatedSize, 0);
                bricksCount++;
                bricksAlignedToSize.put(accumulatedSize, bricksCount);
                maxNumOfBricksAligned = Math.max(maxNumOfBricksAligned, bricksCount);
            }
        }

        return rowCount - maxNumOfBricksAligned;
    }
}
