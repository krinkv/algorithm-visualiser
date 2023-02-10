package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;

import java.util.*;
import java.util.stream.Collectors;

public class Greedy extends AbstractGraph {
    private final List<TraversalStepResult> traversalStepResults;

    private final int goalState;

    private final List<Integer> parent;

    public Greedy(List<NodeDetails> nodes, List<Edge> edges, int goalState) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.parent = initCost(nodes);
        this.parent.add(Integer.MAX_VALUE);
        this.goalState = goalState;
        this.traverse(1);
    }

    private List<Integer> initCost(List<NodeDetails> nodes) {
        return nodes.stream().map(s -> Integer.MAX_VALUE).collect(Collectors.toList());
    }

    private void traverse(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        Node startNode = getNodeByValue(start);

        priorityQueue.add(startNode);
        visited.add(startNode.node().value());
        traversalStepResults.add(new TraversalStepResult(
                new State(startNode.node().value(), startNode.node().heuristic(), NodeColor.RED),
                new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
        ));

        while (!priorityQueue.isEmpty()) {
            Node headNode = priorityQueue.poll();
            traversalStepResults.add(new TraversalStepResult(
                    new State(headNode.node().value(), headNode.node().heuristic(), NodeColor.GREEN),
                    new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
            ));

            if (headNode.node().value() == goalState) {
                break;
            }

            List<Integer> neighbors = headNode.neighbourNodes().stream().map(n -> n.dest()).toList();
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    priorityQueue.add(this.getNodeByValue(neighbor));
                    visited.add(neighbor);
                    traversalStepResults.add(new TraversalStepResult(
                            new State(neighbor, this.getNodeByValue(neighbor).node().heuristic(), NodeColor.RED),
                            new LinkedList<>(priorityQueue.stream().map(n -> n.node().value()).toList())
                    ));
                    parent.set(neighbor, headNode.node().value());
                }
            }
        }

        Integer nd = 8;
        Deque<Integer> path = new ArrayDeque<>();
        while (nd != Integer.MAX_VALUE) {
            path.addFirst(nd);
            nd = parent.get(nd);
        }

        System.out.println(path);
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
