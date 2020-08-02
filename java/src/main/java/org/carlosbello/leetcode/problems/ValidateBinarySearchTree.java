package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

/**
 * 98. Validate Binary Search Tree [medium] https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    private boolean subtreeIsSmallerThan(TreeNode root, int parentVal) {
        return root == null || root.val < parentVal
                && subtreeIsSmallerThan(root.left, parentVal)
                && subtreeIsSmallerThan(root.right, parentVal);
    }

    private boolean subtreeIsGreaterThan(TreeNode root, int parentVal) {
        return root == null || root.val > parentVal
                && subtreeIsGreaterThan(root.left, parentVal)
                && subtreeIsGreaterThan(root.right, parentVal);
    }

    public boolean isValidBST(TreeNode root) {
        return root == null
                || subtreeIsSmallerThan(root.left, root.val) && subtreeIsGreaterThan(root.right, root.val)
                && isValidBST(root.left) && isValidBST(root.right);
    }
}
