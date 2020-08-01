package org.carlosbello.leetcode.datastructures.linkedlist;

/**
 * From leetcode definition:
 *
 * // Definition for a Node.
 * class Node {
 *     int val;
 *     Node next;
 *     Node random;
 *
 *     public Node(int val) {
 *         this.val = val;
 *         this.next = null;
 *         this.random = null;
 *     }
 * }
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
