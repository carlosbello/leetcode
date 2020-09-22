package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree [medium] https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {
    private List<TreeNode> pathToNode(TreeNode root, TreeNode node) {
        if (root == null) return List.of();
        if (root.val == node.val) return List.of(root);

        List<TreeNode> path = new ArrayList<>();
        List<TreeNode> pathFromLeft = pathToNode(root.left, node);
        List<TreeNode> pathFromRight = pathFromLeft.isEmpty() ? pathToNode(root.right, node) : List.of();

        if (pathFromLeft.size() + pathFromRight.size() > 0) {
            path.add(root);
        }
        path.addAll(pathFromLeft);
        path.addAll(pathFromRight);

        return path;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        List<TreeNode> pathToP = pathToNode(root, p);
        List<TreeNode> pathToQ = pathToNode(root, q);

        int i;
        for (i = 0;
             i < pathToP.size() && i < pathToQ.size() && pathToP.get(i).val == pathToQ.get(i).val;
             i++);

        return pathToP.get(i - 1);
    }
}
