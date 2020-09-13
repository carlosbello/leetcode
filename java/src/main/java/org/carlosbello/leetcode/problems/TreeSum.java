package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 152. 3Sum [medium] https://leetcode.com/problems/3sum/
 */
public class TreeSum {

    /**
     * Simple approach but repeating search and no memory
     */
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

    private Map<Integer, Integer> buildNumsCount(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        return result;
    }

    private List<Integer> solution(int n1, int n2, int n3) {
        List<Integer> result = new ArrayList<>(List.of(n1, n2, n3));
        result.sort(Integer::compare);
        return result;
    }

    /**
     * Solution that memorize previously processed numbers to avoid repeating calculations
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer, Integer> numsCount = buildNumsCount(nums);
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> firstSeen = new HashSet<>();
        Set<Integer> secondSeen = new HashSet<>();

        for (int first = 0; first < nums.length - 1; first++) {
            if (firstSeen.contains(nums[first])) continue;
            firstSeen.add(nums[first]);

            numsCount.put(nums[first], numsCount.get(nums[first]) - 1);
            for (int second = first + 1; second < nums.length - 1; second++) {
                numsCount.put(nums[second], numsCount.get(nums[second]) - 1);

                if (secondSeen.contains(nums[second])) continue;
                secondSeen.add(nums[second]);

                int third = -(nums[first] + nums[second]);
                if (numsCount.getOrDefault(third, 0) > 0) {
                    result.add(solution(nums[first], nums[second], third));
                }
            }
            secondSeen.clear();
            for (int second = first + 1; second < nums.length - 1; second++) {
                numsCount.put(nums[second], numsCount.get(nums[second]) + 1);
            }
        }

        return new ArrayList<>(result);
    }
}
