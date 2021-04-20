package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.narytree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal [easy] https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        var traversal = new ArrayList<Integer>();
        if (root == null) return traversal;

        traversal.add(root.val);
        root.children.forEach(child -> traversal.addAll(preorder(child)));

        return traversal;
    }
}
