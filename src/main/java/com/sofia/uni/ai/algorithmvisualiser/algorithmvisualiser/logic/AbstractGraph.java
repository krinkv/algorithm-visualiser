package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic;

import java.util.*;

public abstract class AbstractGraph implements Traversal {
    protected LinkedList<Node> graph;

    public AbstractGraph(List<Integer> nodes, List<Edge> edges) {
        this.graph = new LinkedList<>();
        for (int node : nodes) {
            this.graph.add(new Node(node, new LinkedList<>()));
        }

        for (Edge edge : edges) {
            for (Node currentNode : this.graph) {
                if (currentNode.value() == edge.source()) {
                    currentNode.neighbourNodes().add(edge);
                    break;
                }
            }
        }
    }

    void print() {

    }

    public abstract TraversalStepResult getNextState(int index);
}
