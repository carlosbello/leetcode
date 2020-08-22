package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. Permutations [medium] https://leetcode.com/problems/permutations/
 */
public class Permutations {

    /**
     * Better: calling only once permute() of nums.length - 1 elements; and doesn't create the stream
     */
    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length < 2) {
            return List.of(nums.length == 1 ? List.of(nums[0]) : List.of());
        }
        List<List<Integer>> result = new ArrayList<>();

        int n = nums[0];
        List<List<Integer>> restPermute = permute(Arrays.copyOfRange(nums, 1, nums.length));

        for (int i = 0; i < nums.length; i++) {
            for(List<Integer> list: restPermute) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, n);
                result.add(newList);
            }
        }
        return result;
    }

    private int[] except(int[] nums, int index) {
        int[] result = new int[nums.length - 1];
        System.arraycopy(nums, 0, result, 0, index);
        System.arraycopy(nums, index + 1, result, index, nums.length - index - 1);
        return result;
    }

    /**
     * First approach, slower: calling nums.length times permute() of nums.length - 1 elements
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 2) {
            return List.of(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] rest = except(nums, i);
            List<List<Integer>> restPermute = permute(rest);
            for(List<Integer> list: restPermute) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(0, n);
                result.add(newList);
            }
        }
        return result;
    }
}
