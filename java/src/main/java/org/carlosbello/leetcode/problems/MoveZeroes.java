package org.carlosbello.leetcode.problems;

/**
 * 283. Move Zeroes [easy] https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zerosCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zerosCount++;
            } else if (zerosCount > 0) {
                nums[i - zerosCount] = nums[i];
            }
        }
        while (zerosCount > 0) {
            nums[nums.length - zerosCount] = 0;
            zerosCount--;
        }
    }
}
