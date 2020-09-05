package org.carlosbello.leetcode.problems;

/**
 * 33. Search in Rotated Sorted Array [medium] https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int midIndex = (endIndex - startIndex) / 2;
        while (startIndex <= endIndex && nums[midIndex] != target) {
            if (target < nums[midIndex]) {
                if (nums[startIndex] > nums[midIndex] || nums[startIndex] <= target) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            } else {
                if (nums[midIndex] > nums[endIndex] || target <= nums[endIndex]) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            }
            midIndex = (endIndex + startIndex) / 2;
        }
        return startIndex <= endIndex ? midIndex : -1;
    }
}
