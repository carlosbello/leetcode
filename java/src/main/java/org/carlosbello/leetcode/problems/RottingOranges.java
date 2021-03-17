package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 994. Rotting Oranges [medium] https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {
    private Set<Pair<Integer, Integer>> getOrangesWithStatus(int[][] grid, int status) {
        Set<Pair<Integer, Integer>> oranges = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == status) {
                    oranges.add(new Pair<>(i, j));
                }
            }
        }

        return oranges;
    }

    private Set<Pair<Integer, Integer>> getFreshOranges(int[][] grid) {
        return getOrangesWithStatus(grid, 1);
    }

    private Set<Pair<Integer, Integer>> getRotenOranges(int[][] grid) {
        return getOrangesWithStatus(grid, 2);
    }

    private List<Pair<Integer, Integer>> getFreshAdjacents(int[][] grid, Pair<Integer, Integer> rotenOrange) {
        List<Pair<Integer, Integer>> freshAdjacents = new ArrayList<>();
        int i = rotenOrange.getKey();
        int j = rotenOrange.getValue();

        if (i - 1 >= 0 && grid[i-1][j] == 1) freshAdjacents.add(new Pair<>(i-1, j));
        if (i + 1 < grid.length && grid[i+1][j] == 1) freshAdjacents.add(new Pair<>(i+1, j));
        if (j - 1 >= 0 && grid[i][j-1] == 1) freshAdjacents.add(new Pair<>(i, j-1));
        if (j + 1 < grid[i].length && grid[i][j+1] == 1) freshAdjacents.add(new Pair<>(i, j+1));

        return freshAdjacents;
    }

    public int orangesRotting(int[][] grid) {
        Set<Pair<Integer, Integer>> freshOranges = getFreshOranges(grid);
        Set<Pair<Integer, Integer>> rotenOranges = getRotenOranges(grid);
        int steps = 0;

        while (!freshOranges.isEmpty() && !rotenOranges.isEmpty()) {
            Set<Pair<Integer, Integer>> nextRotenOranges = new HashSet<>();
            for (Pair<Integer, Integer> rotenOrange: rotenOranges) {
                List<Pair<Integer, Integer>> freshAdgacents = getFreshAdjacents(grid, rotenOrange);
                freshAdgacents.forEach(orange -> grid[orange.getKey()][orange.getValue()] = 2);
                freshOranges.removeAll(freshAdgacents);
                nextRotenOranges.addAll(freshAdgacents);
            }
            rotenOranges = nextRotenOranges;
            steps++;
        }

        return freshOranges.isEmpty() ? steps : -1;
    }
}
