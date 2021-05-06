package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.binarytree.TreeNode;
import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. Convert Sorted List to Binary Search Tree [medium] https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
    private List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode current = head; current != null; current = current.next) {
            list.add(current.val);
        }
        return list;
    }

    private TreeNode toBST(List<Integer> list, int from, int to) {
        if (from > to) return null;
        int mid = (from + to) / 2;
        return new TreeNode(list.get(mid), toBST(list, from, mid - 1), toBST(list, mid + 1, to));
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        var list = toList(head);
        return toBST(list, 0, list.size() - 1);
    }
}
