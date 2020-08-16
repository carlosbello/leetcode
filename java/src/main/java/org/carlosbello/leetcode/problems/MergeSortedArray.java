package org.carlosbello.leetcode.problems;

/**
 * 88. Merge Sorted Array [easy] https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    private void insertRight(int[] nums, int fromPosition, int toPosition, int value) {
        for(int i = fromPosition; i > toPosition; i--) {
            nums[i] = nums[i-1];
        }
        nums[toPosition] = value;
    }


    /**
     * First (accepted) slower approach
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        for (int index2 = 0; index2 < n; index2++) {
            while (index1 < m+index2 && nums1[index1] < nums2[index2]) {
                index1++;
            }
            insertRight(nums1, m+index2, index1, nums2[index2]);
            index1++;
        }
    }

    /**
     * Fastest linear approach
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int insertIndex = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[insertIndex] = nums1[index1];
                index1--;
            } else {
                nums1[insertIndex] = nums2[index2];
                index2--;
            }
            insertIndex--;
        }
        System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
    }
}
