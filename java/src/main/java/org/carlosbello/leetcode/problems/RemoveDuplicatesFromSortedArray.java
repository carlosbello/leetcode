package org.carlosbello.leetcode.problems;

/**
 * 26. Remove Duplicates from Sorted Array [easy] https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int newLength = 1;
        int currentVal = nums[0];
        for (int currentPos = 1; currentPos < nums.length; currentPos++) {
            if (currentVal != nums[currentPos]) {
                currentVal = nums[currentPos];
                nums[newLength] = currentVal;
                newLength++;
            }
        }

        return newLength;
    }
}
