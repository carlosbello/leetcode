package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 329. Longest Increasing Path in a Matrix [hard] https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {
    private List<int[]> getNeighbors(int row, int col, int[][] matrix) {
        List<int[]> neighbors = new ArrayList<>();
        if (row - 1 >= 0 && matrix[row - 1][col] > matrix[row][col]) {
            neighbors.add(new int[] {row - 1, col});
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
            neighbors.add(new int[] {row + 1, col});
        }
        if (col - 1 >= 0 && matrix[row][col - 1] > matrix[row][col]) {
            neighbors.add(new int[] {row, col - 1});
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] > matrix[row][col]) {
            neighbors.add(new int[] {row, col + 1});
        }
        return neighbors;
    }

    private int longestIP(int startingRow, int startingCol, int[][] longestSeen, int[][] matrix) {
        if (longestSeen[startingRow][startingCol] > 0) return longestSeen[startingRow][startingCol];

        int longest = 1;
        List<int[]> neighbors = getNeighbors(startingRow, startingCol, matrix);
        for (int[] neighbor: neighbors) {
            longest = Math.max(longest, 1 + longestIP(neighbor[0], neighbor[1], longestSeen, matrix));
        }
        longestSeen[startingRow][startingCol] = longest;

        return longest;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] longestSeen = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                longest = Math.max(longest, longestIP(row, col, longestSeen, matrix));
            }
        }
        return longest;
    }
}
