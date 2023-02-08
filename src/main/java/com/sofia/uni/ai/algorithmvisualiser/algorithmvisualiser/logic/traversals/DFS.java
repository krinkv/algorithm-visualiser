package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class DFS extends AbstractGraph {
    private final LinkedList<TraversalStepResult> traversalStepResults;

    public DFS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.traverse(1);
        System.out.println("echo");
    }

    public void traverse(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(start);
        visited.add(start);
        this.traversalStepResults.add(new TraversalStepResult(
                new State(start, NodeColor.RED), copyStack(stack)
        ));
        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (Map<Integer, LinkedList<Integer>> m : graph) {
                if (m.containsKey(current)) {
                    LinkedList<Integer> neighbors = m.get(current);
                    for (int neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                            visited.add(neighbor);
                            this.traversalStepResults.add(new TraversalStepResult(
                                    new State(neighbor, NodeColor.RED), copyStack(stack)
                            ));
                        }
                    }
                }
            }
            this.traversalStepResults.add(new TraversalStepResult(
                    new State(current, NodeColor.GREEN), copyStack(stack)
            ));
        }
    }

    public LinkedList<TraversalStepResult> getTraversalStepResults() {
        return traversalStepResults;
    }

    public TraversalStepResult getNextState(int index) {
        return null;
    }

    private Deque<Integer> copyStack(Stack stack) {

        return new LinkedList<>(stack);
    }
}
