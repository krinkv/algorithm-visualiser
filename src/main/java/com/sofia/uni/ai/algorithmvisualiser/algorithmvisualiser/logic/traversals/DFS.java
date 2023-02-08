package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.AbstractGraph;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.TraversalStepResult;

import java.util.List;

public class DFS extends AbstractGraph {
    public DFS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
    }

    public TraversalStepResult getNextState(int index) {
        return null;
    }
}
