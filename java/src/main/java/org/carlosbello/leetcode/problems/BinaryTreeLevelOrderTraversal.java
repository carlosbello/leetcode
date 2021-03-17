package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 102. Binary Tree Level Order Traversal [medium] https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Slower functional version (8ms)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> visited = new ArrayList<>();

        List<TreeNode> toVisit = root != null ? List.of(root) : List.of();
        while (!toVisit.isEmpty()) {
            visited.add(toVisit.stream().map(node -> node.val).collect(Collectors.toList()));
            toVisit = toVisit.stream()
                    .map(node -> new TreeNode[] {node.left, node.right})
                    .flatMap(Arrays::stream)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        return visited;
    }

    /**
     * Faster not functional version (1ms)
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> visited = new ArrayList<>();

        List<TreeNode> toVisit = root != null ? List.of(root) : List.of();
        while (!toVisit.isEmpty()) {
            List<TreeNode> nextToVisit = new ArrayList<>();
            List<Integer> visiting = new ArrayList<>();
            for (TreeNode node: toVisit) {
                visiting.add(node.val);
                if (node.left != null) nextToVisit.add(node.left);
                if (node.right != null) nextToVisit.add(node.right);
            }
            visited.add(visiting);
            toVisit = nextToVisit;
        }

        return visited;
    }
}
