package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal [medium] https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;

        boolean leftToRight = true;
        Queue<List<TreeNode>> toVisitQueue = new ArrayDeque<>();
        toVisitQueue.add(List.of(root));

        while (!toVisitQueue.isEmpty()) {
            List<TreeNode> toVisitNodes = new ArrayList<>();;
            LinkedList<Integer> visited = new LinkedList<>();
            for (TreeNode node: toVisitQueue.remove()) {
                if (leftToRight) {
                    visited.addLast(node.val);
                } else {
                    visited.addFirst(node.val);
                }
                if (node.left != null) toVisitNodes.add(node.left);
                if (node.right != null) toVisitNodes.add(node.right);
            }
            if (toVisitNodes.size() > 0) toVisitQueue.add(toVisitNodes);
            traversal.add(visited);
            leftToRight = !leftToRight;
        }

        return traversal;
    }
}
