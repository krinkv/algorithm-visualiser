package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class BFS extends AbstractGraph {
    private final LinkedList<TraversalStepResult> traversalStepResults;

    public BFS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.traverse(1);
        System.out.println("echo");
    }

    public void traverse(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Map<Integer, LinkedList<Integer>> map : graph) {
            int node = map.keySet().iterator().next();
            if (node == start) {
                queue.offer(node);
                visited.add(node);
                traversalStepResults.add(new TraversalStepResult(
                        new State(node, NodeColor.RED), copyQueue(queue)
                ));
            }
            while (!queue.isEmpty()) {
                int current = queue.peek();
                for (Map<Integer, LinkedList<Integer>> m : graph) {
                    if (m.containsKey(current)) {
                        LinkedList<Integer> neighbors = m.get(current);
                        for (int neighbor : neighbors) {
                            if (!visited.contains(neighbor)) {
                                queue.offer(neighbor);
                                visited.add(neighbor);
                                traversalStepResults.add(new TraversalStepResult(
                                        new State(neighbor, NodeColor.RED), copyQueue(queue)
                                ));
                            }
                        }
                    }
                }
                int removed = queue.poll();
                traversalStepResults.add(new TraversalStepResult(
                        new State(removed, NodeColor.GREEN), copyQueue(queue))
                );
            }
        }
    }

    public LinkedList<TraversalStepResult> getTraversalStepResults() {
        return traversalStepResults;
    }

    @Override
    public TraversalStepResult getNextState(int index) {
        return this.traversalStepResults.get(index);
    }

    private Deque<Integer> copyQueue(Queue<Integer> queue) {
        Deque<Integer> queueCopy = new LinkedList<>();
        queueCopy.addAll(queue);

        return queueCopy;
    }
}
