package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

/**
 * 1022. Sum of Root To Leaf Binary Numbers [easy] https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {
    private int sum;

    private void dfs(TreeNode root, String path) {
        if (root == null) return;

        String currentPath = path + (root.val == 0 ? "0" : "1");

        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(currentPath, 2);
            return;
        }

        dfs(root.left, currentPath);
        dfs(root.right, currentPath);
    }

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;

        dfs(root, "");

        return sum;
    }
}
