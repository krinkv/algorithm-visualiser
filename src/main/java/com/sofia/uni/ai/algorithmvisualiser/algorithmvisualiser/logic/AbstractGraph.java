package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic;

import java.util.*;

public abstract class AbstractGraph implements Traversal {
    protected LinkedList<Map<Integer, LinkedList<Integer>>> graph;

    public AbstractGraph(List<Integer> nodes, List<Edge> edges) {
        this.graph = new LinkedList<>();
        for (int node : nodes) {
            Map<Integer, LinkedList<Integer>> map = new HashMap<>();
            map.put(node, new LinkedList<>());
            this.graph.add(map);
        }

        for (Edge edge : edges) {
            int node1 = edge.source();
            int node2 = edge.dest();
            for (Map<Integer, LinkedList<Integer>> map : this.graph) {
                if (map.containsKey(node1)) {
                    map.get(node1).add(node2);
                    break;
                }
            }
        }
    }

    void print() {

    }

    public abstract TraversalStepResult getNextState(int index);
}
