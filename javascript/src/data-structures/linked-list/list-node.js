class ListNode {
    /**
     * @param {*} val
     * @param {ListNode} next
     */
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }

    toString() {
        return `[${this.val}, ${this.next ? this.next.toString() : 'null'}]`;
    }
}

module.exports = ListNode;
