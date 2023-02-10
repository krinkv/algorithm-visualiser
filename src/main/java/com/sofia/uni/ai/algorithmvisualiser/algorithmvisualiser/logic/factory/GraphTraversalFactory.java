package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.NodeDetails;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Traversal;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals.BFS;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals.DFS;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals.Greedy;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals.UCS;

import java.util.List;

public class GraphTraversalFactory {
    public static Traversal constructGraph(List<NodeDetails> nodes, List<Edge> edges, Algorithm algorithm) {
        if (algorithm == Algorithm.BFS) {
            return new BFS(nodes, edges);
        } else if (algorithm == Algorithm.DFS) {
            return new DFS(nodes, edges);
        } else if (algorithm == Algorithm.UCS) {
            return new UCS(nodes, edges, 6);
        } else if (algorithm == Algorithm.GREEDY) {
            return new Greedy(nodes, edges, 8);
        }

        return null;
    }
}
