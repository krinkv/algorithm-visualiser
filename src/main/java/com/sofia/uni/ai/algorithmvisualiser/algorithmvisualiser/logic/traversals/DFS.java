package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.AbstractGraph;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.State;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DFS extends AbstractGraph {
    public DFS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
    }

    public Map<State, Queue<Integer>> getNextState(int index) {
        return null;
    }
}
