package org.carlosbello.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 47. Permutations II [medium] https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    private Set<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return Set.of(List.of(nums[0]));
        }
        Set<List<Integer>> result = new HashSet<>();

        int n = nums[0];
        Set<List<Integer>> restPermute = permute(Arrays.copyOfRange(nums, 1, nums.length));

        for (int i = 0; i < nums.length; i++) {
            for(List<Integer> list: restPermute) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, n);
                result.add(newList);
            }
        }
        return result;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return nums.length == 0
                ? List.of(List.of())
                : new LinkedList<>(permute(nums));
    }
}
