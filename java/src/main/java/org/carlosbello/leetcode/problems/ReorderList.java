package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

import java.util.Stack;

/**
 * 143. Reorder List [medium] https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    private ListNode getMiddleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    private ListNode reverse(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pointer = head;
        ListNode reversed = null;

        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.next;
        }

        reversed = stack.pop();
        pointer = reversed;
        while (!stack.empty()) {
            pointer.next = stack.pop();
            pointer = pointer.next;
        }
        pointer.next = null;

        return reversed;
    }

    /**
     * Second approach, just with pointers and no stack usage
     */
    private ListNode reverse2(ListNode head) {
        ListNode reversed = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        return reversed;
    }

    private void merge(ListNode head1, ListNode head2, ListNode middle) {
        ListNode pointer1 = head1;
        ListNode pointer2 = head2;

        while (pointer2 != middle) {
            ListNode next1 = pointer1.next;
            ListNode next2 = pointer2.next;

            pointer1.next = pointer2;
            pointer1 = next1;
            pointer2.next = next1;
            pointer2 = next2;
        }
    }

    /**
     * Second approach, get ride of middle node reference
     */
    private void merge2(ListNode head1, ListNode head2) {
        ListNode pointer1 = head1;
        ListNode pointer2 = head2;

        while (pointer2.next != null) {
            ListNode next1 = pointer1.next;
            ListNode next2 = pointer2.next;

            pointer1.next = pointer2;
            pointer1 = next1;
            pointer2.next = next1;
            pointer2 = next2;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode middle = getMiddleNode(head);
        ListNode reversed = reverse(middle);
        merge(head, reversed, middle);
    }

    /**
     * Same approach than reorderList but using improved implementations
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode middle = getMiddleNode(head);
        ListNode reversed = reverse2(middle);
        merge2(head, reversed);
    }
}
