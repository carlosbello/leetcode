package org.carlosbello.leetcode.problems;

/**
 * 238. Product of Array Except Self [medium] https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProductExcept = new int[nums.length];
        int[] rightProductExcept = new int[nums.length];
        int[] result = new int[nums.length];
        leftProductExcept[0] = 1;
        rightProductExcept[nums.length-1] = 1;

        for (int leftIndex = 1, rightIndex = nums.length - 2;
             leftIndex < nums.length;
             leftIndex++, rightIndex--)
        {
            leftProductExcept[leftIndex] = leftProductExcept[leftIndex-1] * nums[leftIndex-1];
            rightProductExcept[rightIndex] = rightProductExcept[rightIndex+1] * nums[rightIndex+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProductExcept[i] * rightProductExcept[i];
        }

        return result;
    }
}
