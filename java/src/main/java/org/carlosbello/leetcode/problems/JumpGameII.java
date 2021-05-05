package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 45. Jump Game II [medium] https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        for (int current = 0; current < nums.length && steps[nums.length - 1] == Integer.MAX_VALUE; current++) {
            for (int step = 1; step <= nums[current] && current + step < nums.length; step++) {
                steps[current + step] = Math.min(steps[current + step], steps[current]  + 1);
            }
        }
        return steps[nums.length - 1];
    }
}
