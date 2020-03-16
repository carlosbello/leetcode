const ListNode = require('./list-node');

/**
 * 234. Palindrome Linked https://leetcode.com/problems/palindrome-linked-list/
 *
 * This approach uses *only* linked lists as a data structure. See {@link isPalindrome2}
 * for a much simpler (but not faster) version that uses an array.
 *
 * @param {ListNode} head
 * @returns {boolean}
 */
const isPalindrome1 = head => {
    const reversed = listHead => {
        let head = new ListNode(listHead.val);
        let current = listHead;
        let length = 1;
        while (current.next) {
            const newHead = new ListNode(current.next.val);
            newHead.next = head;
            head = newHead;
            current = current.next;
            length++;
        }
        return { head, length };
    };

    if (!head) {
        return true;
    }

    let { head: currentReversed, length } = reversed(head);
    let currentOriginal = head;
    let compared = 0;
    const midPoint = Math.floor(length / 2);
    while (currentOriginal.val === currentReversed.val && compared < midPoint) {
        currentOriginal = currentOriginal.next;
        currentReversed = currentReversed.next;
        compared++;
    }

    return compared >= midPoint;
};

/**
 * 234. Palindrome Linked https://leetcode.com/problems/palindrome-linked-list/
 *
 * This solution is much simpler than {@link isPalindrome1} but uses a different data structure
 * @param {ListNode} head
 */
const isPalindrome2 = head => {
    let values = [];
    while (head) {
        values.push(head.val);
        head = head.next;
    }
    return values.every((v, i) => v === values[values.length - 1 - i]);
};

module.exports = { isPalindrome1, isPalindrome2 };
