package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 303. Range Sum Query - Immutable [easy] https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {

    /**
     * Brute force, repeating calculations
     */
    class NumArray1 {
        private final int[] nums;

        public NumArray1(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int index = i; index <= j; index++) {
                sum += this.nums[index];
            }
            return sum;
        }
    }

    /**
     * Naive, caching previously seen intervals
     */
    class NumArray2 {
        private final int[] nums;
        private final Map<int[], Integer> sums = new HashMap<>();

        public NumArray2(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int[] interval = {i, j};
            if (sums.containsKey(interval)) return sums.get(interval);

            int sum = 0;
            for (int index = i; index <= j; index++) {
                sum += this.nums[index];
            }
            sums.put(interval, sum);
            return sum;
        }
    }

    /**
     * Fastest, supported by the property of sum(i, j) = sum(0, j) - sum(0, i - 1)
     */
    class NumArray3 {
        private final int[] sums;

        public NumArray3(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }
}
