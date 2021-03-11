package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 323. Number of Connected Components in an Undirected Graph [medium] https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    private Map<Integer, List<Integer>> buildNeighboursByNode(int n, int[][] edges) {
        Map<Integer, List<Integer>> neighbours = new HashMap<>();

        for (int node = 0; node < n; node ++) {
            neighbours.put(node, new ArrayList<Integer>());
        }

        for (int[] edge: edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        return neighbours;
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> neighboursByNode = buildNeighboursByNode(n, edges);
        boolean[] visited = new boolean[n];
        Queue<Integer> pendingToVisit = new ArrayDeque<>();
        int connectedComponents = 0;

        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;

            pendingToVisit.add(node);
            connectedComponents++;
            while (!pendingToVisit.isEmpty()) {
                int visitingNode = pendingToVisit.remove();
                visited[visitingNode] = true;
                List<Integer> neightbours = neighboursByNode.get(visitingNode);
                for (int neighbour: neightbours) {
                    if (!visited[neighbour]) {
                        pendingToVisit.add(neighbour);
                    }
                }
            }
        }

        return connectedComponents;
    }
}
