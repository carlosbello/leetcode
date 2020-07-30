package org.carlosbello.leetcode.problems;

/**
 * 31. Next Permutation [medium] https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    private void reverse(int[] nums, int fromIndex, int toIndex) {
        while (fromIndex < toIndex) {
            swap(nums, fromIndex, toIndex);
            fromIndex++;
            toIndex--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0 && nums[i-1] >= nums[i]; i--);
        if (i > 0) {
            int j = i;
            for(; j < nums.length && nums[i-1] < nums[j]; j++);
            swap(nums, i-1, j-1);
        }
        reverse(nums, i, nums.length - 1);
    }
}
