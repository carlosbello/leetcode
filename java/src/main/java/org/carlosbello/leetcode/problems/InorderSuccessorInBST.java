package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

/**
 * 285. Inorder Successor in BST [medium] https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorInBST {
    private TreeNode smallestChild(TreeNode root) {
        return root.left == null ? root : smallestChild(root.left);
    }

    private TreeNode rihtSmallestChildOrParent(TreeNode root, int target, TreeNode rightParent) {
        if (root == null) return null;

        if (root.val == target) return root.right != null ? smallestChild(root.right) : rightParent;

        return target < root.val
            ? rihtSmallestChildOrParent(root.left, target, root)
            : rihtSmallestChildOrParent(root.right, target, rightParent);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return rihtSmallestChildOrParent(root, p.val, null);
    }
}
