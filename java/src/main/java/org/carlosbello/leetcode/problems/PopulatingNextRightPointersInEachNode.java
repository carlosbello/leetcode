package org.carlosbello.leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. Populating Next Right Pointers in Each Node [medium] https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;

        Deque<Node> toVisit = new LinkedList<>();
        toVisit.add(root);

        while (!toVisit.isEmpty()) {
            int pending = toVisit.size();
            while (--pending >= 0) {
                Node current = toVisit.removeFirst();
                if (current.left != null) {
                    toVisit.add(current.left);
                    toVisit.add(current.right);
                }
                if (pending > 0) {
                    current.next = toVisit.peekFirst();
                }
            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
