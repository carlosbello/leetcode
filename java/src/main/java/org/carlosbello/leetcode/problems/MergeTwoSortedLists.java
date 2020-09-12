package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

/**
 * 21. Merge Two Sorted Lists [easy] https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode mergePointer = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mergePointer.next = l1;
                l1 = l1.next;
            } else {
                mergePointer.next = l2;
                l2 = l2.next;
            }
            mergePointer = mergePointer.next;
        }
        if (l1 != null) {
            mergePointer.next = l1;
        }
        if (l2 != null) {
            mergePointer.next = l2;
        }

        return head.next;
    }
}
