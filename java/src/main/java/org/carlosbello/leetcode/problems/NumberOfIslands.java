package org.carlosbello.leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 200. Number of Islands [medium] https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    private List<int[]> neightbors(int[][] map, int row, int col, int mark) {
        List<int[]> possibleNeightbors = new ArrayList<>();
        if (row - 1 >= 0 && map[row - 1][col] == 1) {
            map[row - 1][col] = mark;
            possibleNeightbors.add(new int[] {row - 1, col});
        }
        if (row + 1 < map.length && map[row + 1][col] == 1) {
            map[row + 1][col] = mark;
            possibleNeightbors.add(new int[] {row + 1, col});
        }
        if (col - 1 >= 0 && map[row][col - 1] == 1) {
            map[row][col - 1] = mark;
            possibleNeightbors.add(new int[] {row, col - 1});
        }
        if (col + 1 < map[row].length && map[row][col + 1] == 1) {
            map[row][col + 1] = mark;
            possibleNeightbors.add(new int[] {row, col + 1});
        }

        return possibleNeightbors;
    }

    private void markNeighbours(int[][] map, int row, int col, int mark) {
        Deque<int[]> toMark = new ArrayDeque<>();
        toMark.push(new int[] {row, col});
        while (toMark.size() > 0) {
            int[] island = toMark.pop();
            map[island[0]][island[1]] = mark;
            toMark.addAll(neightbors(map, island[0], island[1], mark));
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int[][] map = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                map[row][col] = grid[row][col] - '0';
            }
        }

        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] <= 0) continue;
                count--;
                markNeighbours(map, row, col, count);
            }
        }
        return -count;
    }
}
