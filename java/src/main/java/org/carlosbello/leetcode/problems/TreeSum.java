package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 152. 3Sum [medium] https://leetcode.com/problems/3sum/
 */
public class TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        List<List<Integer>> solutions = new ArrayList<>();
        Set<List<Integer>> solutionHashes = new HashSet<>();
        for (int i = 0; i < sortedNums.length - 2; i ++) {
            for (int j = i + 1; j < sortedNums.length - 1; j++) {
                int k = -(sortedNums[i] + sortedNums[j]);
                List<Integer> solution = Arrays.asList(sortedNums[i], sortedNums[j], k);
                if (0 <= Arrays.binarySearch(sortedNums, j + 1, sortedNums.length, k) &&
                        !solutionHashes.contains(solution)) {
                    solutions.add(solution);
                    solutionHashes.add(solution);
                }
            }
        }
        return solutions;
    }
}
