package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

/**
 * 2. Add Two Numbers [medium] https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode previous = null;
        int rest = 0;
        int sum = 0;
        ListNode d1 = l1;
        ListNode d2 = l2;

        while (d1 != null || d2 != null) {
            sum = rest;
            if (d1 != null) {
                sum += d1.val;
                d1 = d1.next;
            }
            if (d2 != null) {
                sum += d2.val;
                d2 = d2.next;
            }

            rest = sum / 10;
            current.val = sum % 10;
            previous = current;
            current.next = new ListNode(0);
            current = current.next;
        }

        current.val = rest;
        if (current.val == 0 && previous != null) {
            previous.next = null;
        }

        return result;
    }
}
