package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer [medium] https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cloneMap = new HashMap<>();
        Node pointer = head;
        while (pointer != null) {
            Node clone = new Node(pointer.val);
            cloneMap.put(pointer, clone);
            pointer = pointer.next;
        }
        for (Map.Entry<Node, Node> clonePair : cloneMap.entrySet()) {
            Node original = clonePair.getKey();
            Node clone = clonePair.getValue();
            clone.next = cloneMap.get(original.next);
            clone.random = cloneMap.get(original.random);
        }
        return cloneMap.get(head);
    }
}
