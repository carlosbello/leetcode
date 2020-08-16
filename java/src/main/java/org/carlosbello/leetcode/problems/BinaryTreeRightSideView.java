package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View [medium] https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    private List<Integer> sideViewList;
    private int maxLevel;

    private void traverse(TreeNode node, int currentLevel) {
        if (node == null) {
            return;
        }
        if (currentLevel > maxLevel) {
            sideViewList.add(node.val);
            maxLevel = currentLevel;
        }
        traverse(node.right, currentLevel + 1);
        traverse(node.left, currentLevel + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        sideViewList = new ArrayList<>();
        maxLevel = 0;
        traverse(root, 1);
        return sideViewList;
    }
}
