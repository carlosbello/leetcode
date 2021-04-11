package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

/**
 * 1302. Deepest Leaves Sum [medium] https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLeavesSum {
    private int deepestLevel;
    private int leavesSum;

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            if (level == deepestLevel) {
                leavesSum += node.val;
            }
            if (level > deepestLevel) {
                deepestLevel = level;
                leavesSum = node.val;
            }
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        deepestLevel = 0;
        leavesSum = 0;

        dfs(root, 0);

        return leavesSum;
    }
}
