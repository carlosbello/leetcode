package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

/**
 * 101. Symmetric Tree [easy] https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    boolean areReflectedTwins(TreeNode node1, TreeNode node2) {
        return node1 == null && node2 == null || (
            node1 != null && node2 != null && node1.val == node2.val &&
                areReflectedTwins(node1.left, node2.right) &&
                areReflectedTwins(node1.right, node2.left)
        );
    }

    public boolean isSymmetric(TreeNode root) {
        return areReflectedTwins(root.left, root.right);
    }
}
