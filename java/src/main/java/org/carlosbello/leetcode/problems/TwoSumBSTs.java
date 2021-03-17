package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1214. Two Sum BSTs [medium] https://leetcode.com/problems/two-sum-bsts/
 */
public class TwoSumBSTs {
    private Set<Integer> treeValues(TreeNode root) {
        Set<Integer> values = new HashSet<>();
        if (root == null) return values;

        values.add(root.val);
        values.addAll(treeValues(root.left));
        values.addAll(treeValues(root.right));

        return values;
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> tree1Values = treeValues(root1);
        Set<Integer> tree2Values = treeValues(root2);

        return tree1Values.stream().anyMatch(value1 -> tree2Values.contains(target - value1));
    }
}
