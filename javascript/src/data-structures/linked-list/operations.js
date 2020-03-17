// eslint-disable-next-line no-unused-vars
const ListNode = require('./list-node');
const Node = require('./node');

/**
 * 83. Remove Duplicates from Sorted List https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
const deleteDuplicates = head => {
    let current = head;
    while (!!current && !!current.next) {
        let next = current.next;
        while (!!next && current.val === next.val) {
            next = next.next;
        }
        current.next = next;
        current = next;
    }
    return head;
};

/**
 * 82. Remove Duplicates from Sorted List II https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
const deleteAllDuplicates = head => {
    if (!head || !head.next) {
        return head;
    }

    if (head.val === head.next.val) {
        do {
            head = head.next;
        } while (head && (!head.next || head.val === head.next.val));
        if (head) {
            head = deleteAllDuplicates(head.next);
        }
    } else {
        head.next = deleteAllDuplicates(head.next);
    }
    return head;
};

/**
 * 206. Reverse Linked List https://leetcode.com/problems/reverse-linked-list/
 *
 * @param {ListNode} head
 * @returns {ListNode}
 */
const reverseList = head => {
    if (!head) {
        return head;
    }
    let headOfReversed = new ListNode(head.val);
    let current = head;

    while (current.next) {
        const newHead = new ListNode(current.next.val);
        newHead.next = headOfReversed;
        headOfReversed = newHead;
        current = current.next;
    }
    return headOfReversed;
};

/**
 * 21. Merge Two Sorted Lists https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @returns {ListNode}
 */
const mergeTwoLists = (l1, l2) => {
    let newHead;
    let current1;
    let current2;
    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }
    if (l1.val <= l2.val) {
        newHead = l1;
        current1 = l1.next;
        current2 = l2;
    } else {
        newHead = l2;
        current1 = l1;
        current2 = l2.next;
    }
    let newCurrent = newHead;
    while (current1 && current2) {
        if (current1.val <= current2.val) {
            newCurrent.next = current1;
            current1 = current1.next;
        } else {
            newCurrent.next = current2;
            current2 = current2.next;
        }
        newCurrent = newCurrent.next;
    }
    if (current1) {
        newCurrent.next = current1;
    } else {
        newCurrent.next = current2;
    }
    return newHead;
};

/**
 * @typedef {Object} RandomListNode
 * @property {*} val
 * @property {RandomListNode} next
 * @property {RandomListNode} random
 */

/**
 * 138. Copy List with Random Pointer https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * @param {RandomListNode} head
 * @returns {RandomListNode}
 */
const copyRandomList = head => {
    /** @type Map<RandomListNode, RandomListNode> */
    const nodeToClone = new Map();
    let current = head;
    while (current) {
        const clone = new Node(current.val);
        nodeToClone.set(current, clone);
        current = current.next;
    }
    for (let [node, clone] of nodeToClone) {
        clone.next = nodeToClone.get(node.next) || null;
        clone.random = nodeToClone.get(node.random) || null;
    }
    return nodeToClone.get(head) || null;
};

module.exports = { deleteDuplicates, deleteAllDuplicates, reverseList, mergeTwoLists, copyRandomList };
