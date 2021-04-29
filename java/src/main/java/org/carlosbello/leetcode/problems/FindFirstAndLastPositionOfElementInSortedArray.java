package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array [medium] https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int midIndex = Arrays.binarySearch(nums, target);
        if (midIndex < 0) return new int[] {-1, -1};

        int leftIndex = midIndex;
        int rightIndex = midIndex;
        int indexAtLeft;
        int indexAtRight;
        do {
            indexAtLeft = Arrays.binarySearch(nums, 0, leftIndex, target);
            if (indexAtLeft >= 0) {
                leftIndex = indexAtLeft;
            }
        } while (indexAtLeft >= 0);
        do {
            indexAtRight = Arrays.binarySearch(nums, rightIndex + 1, nums.length, target);
            if (indexAtRight >= 0) {
                rightIndex = indexAtRight;
            }
        } while (indexAtRight >= 0);

        return new int[] {leftIndex, rightIndex};
    }
}
