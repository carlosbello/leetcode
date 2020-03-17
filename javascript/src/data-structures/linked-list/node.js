class Node {
    /**
     * @param {*} val
     * @param {Node} next
     * @param {Node} random
     */
    constructor(val, next = null, random = null) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    toString() {
        const nodeList = [];
        const nodeToIndex = new Map();
        const nodeToString = n => `[${n.val},${!n.random ? 'null' : nodeToIndex.get(n.random)}]`;
        /** @type Node */
        let current = this;
        let index = 0;
        while (current) {
            nodeList.push(current);
            nodeToIndex.set(current, index);
            current = current.next;
            index++;
        }
        return `[${nodeList.map(nodeToString).join(',')}]`;
    }
}

module.exports = Node;
