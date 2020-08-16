package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.graph.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 133. Clone Graph [medium] https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
    private Map<Integer, Node> clonedNodes;

    private Node clone(Node node) {
        if (node == null) {
            return null;
        }
        if (clonedNodes.containsKey(node.val)) {
            return clonedNodes.get(node.val);
        }

        Node cloned = new Node(node.val);
        clonedNodes.put(cloned.val, cloned);

        for(Node nodeToClone: node.neighbors) {
            cloned.neighbors.add(clone(nodeToClone));
        }

        return cloned;
    }

    public Node cloneGraph(Node node) {
        clonedNodes = new HashMap<>();
        return clone(node);
    }
}
