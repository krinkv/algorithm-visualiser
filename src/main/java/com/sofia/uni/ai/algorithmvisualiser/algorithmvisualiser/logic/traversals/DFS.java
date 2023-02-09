package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class DFS extends AbstractGraph {
    private final LinkedList<TraversalStepResult> traversalStepResults;

    public DFS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.traverse(1);
    }

    public void traverse(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        traverseRec(start,stack, visited);
    }

    public void traverseRec(int start, Stack<Integer> stack, Set<Integer> visited) {
        stack.push(start);
        visited.add(start);
        this.traversalStepResults.add(new TraversalStepResult(
                new State(start, NodeColor.RED), new ArrayDeque<>(stack)
        ));
        for (Node currentNode : graph) {
            if (currentNode.value() == start) {
                LinkedList<Integer> neighbors = currentNode.neighbourNodes();
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        traverseRec(neighbor,stack,visited);
                    }
                }
            }
        }
        int curr = stack.pop();
        this.traversalStepResults.add(new TraversalStepResult(
                new State(curr, NodeColor.GREEN), new ArrayDeque<>(stack)
        ));
    }

    public LinkedList<TraversalStepResult> getTraversalStepResults() {
        return traversalStepResults;
    }

    public TraversalStepResult getNextState(int index) {
        return this.traversalStepResults.get(index);
    }

}
