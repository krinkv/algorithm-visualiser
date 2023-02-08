package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Traversal;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals.BFS;

import java.util.List;

public class GraphTraversalFactory {
    public static Traversal constructGraph(List<Integer> nodes, List<Edge> edges, Algorithm algorithm) {
        if (algorithm == Algorithm.BFS) {
            return new BFS(nodes, edges);
        }

        return null;
    }
}
