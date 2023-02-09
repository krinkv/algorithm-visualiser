package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class BFS extends AbstractGraph {
    private final LinkedList<TraversalStepResult> linkedListStateQueue;

    public BFS(List<Integer> nodes, List<Edge> edges) {
        super(nodes, edges);
        this.linkedListStateQueue = new LinkedList<>();
        this.traverse(1);
    }

    public void traverse(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Map<Integer, LinkedList<Integer>> map : graph) {
            int node = map.keySet().iterator().next();
            if (node == start) {
                queue.offer(node);
                visited.add(node);
                linkedListStateQueue.add(new TraversalStepResult(
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
                                linkedListStateQueue.add(new TraversalStepResult(
                                    new State(neighbor, NodeColor.RED), copyQueue(queue)
                                ));
                            }
                        }
                    }
                }
                int removed = queue.poll();
                linkedListStateQueue.add(new TraversalStepResult(
                    new State(removed, NodeColor.GREEN), copyQueue(queue))
            );
            }
        }
    }

    public LinkedList<TraversalStepResult> getLinkedListStateQueue() {
        return linkedListStateQueue;
    }

    @Override
    public TraversalStepResult getNextState(int index) {
        return this.linkedListStateQueue.get(index);
    }

    private Queue<Integer> copyQueue(Queue<Integer> queue) {
        Queue<Integer> queueCopy = new LinkedList<>();
        queueCopy.addAll(queue);

        return queueCopy;
    }
}
