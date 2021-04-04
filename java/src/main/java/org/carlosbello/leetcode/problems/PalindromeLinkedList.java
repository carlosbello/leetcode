package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.ListNode;

/**
 * 234. Palindrome Linked List [easy] https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode fast = current;
        ListNode reversed = null;
        while (fast != null) {
            reversed =  new ListNode(current.val, reversed);
            current = current.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
                reversed = reversed.next;
            }
        }

        while (current != null && current.val == reversed.val) {
            current = current.next;
            reversed = reversed.next;
        }

        return current == null;
    }
}
