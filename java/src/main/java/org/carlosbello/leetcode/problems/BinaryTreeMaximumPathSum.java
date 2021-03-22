package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum [hard] https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum;
    private int concatenableMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int leftConcatPathSum = concatenableMaxPathSum(root.left);
        int rightConcatPathSum = concatenableMaxPathSum(root.right);
        int nodePathSum = leftConcatPathSum + root.val + rightConcatPathSum;
        int concatPathSum = Math.max(root.val, Math.max(leftConcatPathSum, rightConcatPathSum) + root.val);
        maxSum = Math.max(maxSum, Math.max(nodePathSum, concatPathSum));

        return concatPathSum;
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        concatenableMaxPathSum(root);
        return maxSum;
    }
}
