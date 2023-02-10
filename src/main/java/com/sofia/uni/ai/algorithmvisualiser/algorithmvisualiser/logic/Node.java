package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic;

import java.util.LinkedList;

public record Node(NodeDetails node, LinkedList<Edge> neighbourNodes) implements Comparable<Node> {

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.node().heuristic(), o.node().heuristic());
    }
}
