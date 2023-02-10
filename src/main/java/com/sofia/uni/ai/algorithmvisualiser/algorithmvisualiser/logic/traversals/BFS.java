package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class BFS extends AbstractGraph {
    private final LinkedList<TraversalStepResult> traversalStepResults;

    public BFS(List<NodeDetails> nodes, List<Edge> edges) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.traverse(1);
    }

    public void traverse(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Node currentNode : graph) {
            int node = currentNode.node().value();
            if (node == start) {
                queue.offer(node);
                visited.add(node);
                traversalStepResults.add(new TraversalStepResult(
                        new State(node, 1, NodeColor.RED), copyQueue(queue)
                ));
            }
            while (!queue.isEmpty()) {
                int current = queue.peek();
                for (Node n : graph) {
                    if (n.node().value() == current) {
                        List<Integer> neighbors = n.neighbourNodes().stream().map(Edge::dest).toList();
                        for (int neighbor : neighbors) {
                            if (!visited.contains(neighbor)) {
                                queue.offer(neighbor);
                                visited.add(neighbor);
                                traversalStepResults.add(new TraversalStepResult(
                                        new State(neighbor, 1, NodeColor.RED), copyQueue(queue)
                                ));
                            }
                        }
                    }
                }
                int removed = queue.poll();
                traversalStepResults.add(new TraversalStepResult(
                        new State(removed, 1, NodeColor.GREEN), copyQueue(queue))
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
