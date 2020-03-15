// eslint-disable-next-line no-unused-vars
const ListNode = require('./list-node');

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

module.exports = { deleteDuplicates, deleteAllDuplicates };
