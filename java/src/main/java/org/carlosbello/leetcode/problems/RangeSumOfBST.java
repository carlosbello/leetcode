package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 938. Range Sum of BST [easy] https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    private List<Integer> sortedValues;

    private void traversePrefix(TreeNode root) {
        if (root == null) return;
        traversePrefix(root.left);
        sortedValues.add(root.val);
        traversePrefix(root.right);
    }

    private int findClosestIndex(int L, List<Integer> sortedValues) {
        int index = Collections.binarySearch(sortedValues, L);
        if (index >= 0) return index;

        for (index = 0;
             index < sortedValues.size() && sortedValues.get(index) < L;
             index++);
        return index;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        sortedValues = new ArrayList<>();
        traversePrefix(root);
        int first = Math.min(L, R);
        int last = Math.max(L, R);
        int sum = 0;

        int startSumIndex = findClosestIndex(first, sortedValues);
        for (int index = startSumIndex;
             index < sortedValues.size() && sortedValues.get(index) <= last;
             index++) {
            sum += sortedValues.get(index);
        }
        return sum;
    }
}
