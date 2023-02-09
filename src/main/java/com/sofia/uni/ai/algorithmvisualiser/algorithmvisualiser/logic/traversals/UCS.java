package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.AbstractGraph;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.TraversalStepResult;

import java.util.List;

public class UCS extends AbstractGraph {
    public UCS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
    }

    @Override
    public TraversalStepResult getNextState(int index) {
        return null;
    }
}
