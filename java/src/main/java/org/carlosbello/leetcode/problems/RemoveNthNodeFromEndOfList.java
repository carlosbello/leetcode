package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

/**
 * 19. Remove Nth Node From End of List [medium] https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode prevToDelete = new ListNode(-1, head);
        int steps = 0;
        while (current.next != null) {
            steps++;
            current = current.next;
            if (steps >= n) {
                prevToDelete = prevToDelete.next;
            }
        }
        if (prevToDelete.next == head) {
            head = head.next;
        } else {
            prevToDelete.next = prevToDelete.next.next;
        }

        return head;
    }
}
