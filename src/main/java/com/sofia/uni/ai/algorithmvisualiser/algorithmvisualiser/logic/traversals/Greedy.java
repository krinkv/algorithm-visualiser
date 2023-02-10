package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;

public class Greedy extends AbstractGraph {
    private final List<TraversalStepResult> traversalStepResults;

    private final int goalState;

    public Greedy(List<NodeDetails> nodes, List<Edge> edges, List<TraversalStepResult> traversalStepResults, int goalState) {
        super(nodes, edges);
        this.traversalStepResults = traversalStepResults;
        this.goalState = goalState;
        this.traverse(1);
    }

    private void traverse(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        for (Node currentNode : graph) {
            int node = currentNode.node().value();
            if (node == start) {
                priorityQueue.add(currentNode);
                visited.add(node);
                traversalStepResults.add(new TraversalStepResult(
                        new State(node, NodeColor.RED),
                        new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
                ));
            }
            while (!priorityQueue.isEmpty()) {
                Node headNode = priorityQueue.peek();
                if (headNode.node().value() == goalState){
                    traversalStepResults.add(new TraversalStepResult(
                            new State(headNode.node().value(), NodeColor.RED),
                            new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
                    ));
                    break;
                }
                List<Integer> neighbors = headNode.neighbourNodes().stream().map(n -> n.dest()).toList();
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        priorityQueue.add(this.getNodeByValue(neighbor));
                        visited.add(neighbor);
                        traversalStepResults.add(new TraversalStepResult(
                                new State(neighbor, NodeColor.RED),
                                new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
                        ));
                    }
                }
                Node removed = priorityQueue.poll();
                traversalStepResults.add(new TraversalStepResult(
                        new State(removed.node().value(), NodeColor.RED),
                        new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
                ));
            }
        }

    }


    private Node getNodeByValue(int value) {
        for (Node currNode : graph) {
            if (currNode.node().value() == value) {
                return currNode;
            }
        }
        return null;
    }

    @Override
    public TraversalStepResult getNextState(int index) {
        return this.traversalStepResults.get(index);
    }

}
