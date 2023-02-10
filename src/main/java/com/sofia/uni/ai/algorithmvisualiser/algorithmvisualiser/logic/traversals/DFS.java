package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class DFS extends AbstractGraph {
    private final LinkedList<TraversalStepResult> traversalStepResults;

    public DFS(List<NodeDetails> nodes, List<Edge> edges) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.traverse(1);
    }

    public void traverse(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        traverseRec(start, stack, visited);
    }

    public void traverseRec(int start, Stack<Integer> stack, Set<Integer> visited) {
        stack.push(start);
        visited.add(start);
        this.traversalStepResults.add(new TraversalStepResult(
                new State(start, 1, NodeColor.RED), new ArrayDeque<>(stack)
        ));
        for (Node currentNode : graph) {
            if (currentNode.node().value() == start) {
                List<Integer> neighbors = currentNode.neighbourNodes().stream().map(Edge::dest).toList();
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        traverseRec(neighbor, stack, visited);
                    }
                }
            }
        }
        int curr = stack.pop();
        this.traversalStepResults.add(new TraversalStepResult(
                new State(curr, 1, NodeColor.GREEN), new ArrayDeque<>(stack)
        ));
    }

    public LinkedList<TraversalStepResult> getTraversalStepResults() {
        return traversalStepResults;
    }

    public TraversalStepResult getNextState(int index) {
        return this.traversalStepResults.get(index);
    }

}
