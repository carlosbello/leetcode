package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

/**
 * 86. Partition List [medium] https://leetcode.com/problems/partition-list/
 */
public class PartitionList {

    /**
     * Second approach, building tow lists for smaller elements and equal or bigger elements
     */
    public ListNode partition2(ListNode head, int x) {
        if (head == null) return null;

        ListNode pointer = head;
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;

        while (pointer != null) {
            if (pointer.val < x) {
                if (leftTail == null) {
                    leftTail = new ListNode(pointer.val);
                    leftHead = leftTail;
                } else {
                    leftTail.next = new ListNode(pointer.val);
                    leftTail = leftTail.next;
                }
            } else {
                if (rightTail == null) {
                    rightTail = new ListNode(pointer.val);
                    rightHead = rightTail;
                } else {
                    rightTail.next = new ListNode(pointer.val);
                    rightTail = rightTail.next;
                }
            }
            pointer = pointer.next;
        }

        if (leftHead == null) {
            leftHead = rightHead;
        } else {
            leftTail.next = rightHead;
        }

        return leftHead;
    }

    private ListNode concat(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;

        ListNode pointer = list1;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = list2;

        return list1;
    }

    private ListNode insertSorted(ListNode head, int value, int x) {
        if (head == null) return new ListNode(value);

        if (value < x && head.val >= x) {
            ListNode newHead = new ListNode(value, head);
            return newHead;
        }

        ListNode prev = head;
        while (prev.next != null && (value >= x || prev.next.val < x)) {
            prev = prev.next;
        }
        ListNode newNode = new ListNode(value, prev.next);
        prev.next = newNode;

        return head;
    }

    /**
     * First approach, looking for the mid point and building the lists inserting nodes
     * before and after the mid point
     */
    public ListNode partition1(ListNode head, int x) {
        if (head == null) return null;

        ListNode pointer = head;
        ListNode leftPartition = null;
        ListNode rightPartition = null;

        while (pointer != null && pointer.val != x) {
            leftPartition = insertSorted(leftPartition, pointer.val, x);
            pointer = pointer.next;
        }

        while (pointer != null) {
            if (pointer.val < x) {
                leftPartition = insertSorted(leftPartition, pointer.val, x);
            } else {
                rightPartition = insertSorted(rightPartition, pointer.val, x);
            }
            pointer = pointer.next;
        }

        return concat(leftPartition, rightPartition);
    }
}
