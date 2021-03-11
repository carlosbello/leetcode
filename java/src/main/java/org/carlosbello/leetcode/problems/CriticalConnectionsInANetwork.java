package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 1192. Critical Connections in a Network [hard] https://leetcode.com/problems/critical-connections-in-a-network/
 */
public class CriticalConnectionsInANetwork {
    Map<Integer, List<Integer>> neighbours;
    Map<Integer, Integer> stepsByNode;
    Map<Integer, Set<Integer>> links;

    private Map<Integer, List<Integer>> buildNeighbours(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> neighbours = new HashMap<>();

        for (int i = 0; i < n; i++) {
            neighbours.put(i, new ArrayList<>());
        }

        connections.forEach(connection -> {
            neighbours.get(connection.get(0)).add(connection.get(1));
            neighbours.get(connection.get(1)).add(connection.get(0));
        });

        return neighbours;
    }

    private Map<Integer, Integer> buildStepsByNode(int n) {
        Map<Integer, Integer> stepsByNode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            stepsByNode.put(i, null);
        }

        return stepsByNode;
    }

    private Map<Integer, Set<Integer>> buildUnidirectionalOrderedLinks(List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> unidirectionalOrderedLinks = new HashMap<>();

        for (List<Integer> connection: connections) {
            int fromNode = Math.min(connection.get(0), connection.get(1));
            int toNode = Math.max(connection.get(0), connection.get(1));

            if (!unidirectionalOrderedLinks.containsKey(fromNode)) {
                unidirectionalOrderedLinks.put(fromNode, new HashSet<Integer>());
            }
            unidirectionalOrderedLinks.get(fromNode).add(toNode);
        }

        return unidirectionalOrderedLinks;
    }

    private void removeLink(int node1, int node2) {
        int fromNode = Math.min(node1, node2);
        int toNode = Math.max(node1, node2);
        links.get(fromNode).remove(toNode);
        if (links.get(fromNode).isEmpty()) {
            links.remove(fromNode);
        }
    }

    private List<List<Integer>> buildCriticalConnections(Map<Integer, Set<Integer>> links) {
        List<List<Integer>> criticalConnections = new ArrayList<>();

        links.forEach(
                (node, neighbours) -> neighbours.forEach(
                        neighbour -> criticalConnections.add(List.of(node, neighbour))
                )
        );

        return criticalConnections;
    }

    private int visitNeighbours(int currentNode, int step) {
        List<Integer> currentNeighbours = neighbours.get(currentNode);
        List<Integer> neighbourSteps = new ArrayList<>();
        int minStep = step;
        stepsByNode.put(currentNode, step);

        for (int neighbour: currentNeighbours) {
            Integer neighbourStep = stepsByNode.get(neighbour);

            if (neighbourStep == null) {
                neighbourStep = visitNeighbours(neighbour, step + 1);
            } else if (neighbourStep.equals(step - 1)) {
                continue;
            }
            minStep = Math.min(minStep, neighbourStep);
            if (neighbourStep <= step) {
                removeLink(currentNode, neighbour);
            }
        }

        return minStep;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        neighbours = buildNeighbours(n, connections);
        stepsByNode = buildStepsByNode(n);
        links = buildUnidirectionalOrderedLinks(connections);

        visitNeighbours(0, 0);

        return buildCriticalConnections(links);
    }
}
