package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.traversals;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.*;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.AbstractGraph;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Node;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.TraversalStepResult;

import java.util.*;
import java.util.stream.Collectors;

public class UCS extends AbstractGraph {
    private final PriorityQueue<UCS_NODE> priorityQueue = new PriorityQueue<>();
    private final Set<Integer> visited = new HashSet<>();
    private final List<TraversalStepResult> traversalStepResults;
    private final List<Integer> cost;
    private final List<Integer> parent;
    private final int goalState;

    public UCS(List<Integer> nodes, List<Edge> edges, int goalState) {
        super(nodes, edges);
        this.traversalStepResults = new LinkedList<>();
        this.goalState = goalState;
        this.cost = initCost(nodes);
        this.parent = initCost(nodes);
        this.parent.add(Integer.MAX_VALUE);
        this.traverse(1);
    }

    private List<Integer> initCost(List<Integer> nodes) {
        return nodes.stream().map(s -> Integer.MAX_VALUE).collect(Collectors.toList());
    }

    private void traverse(int start) {
        Node startNode = graph.stream().filter(n -> n.value() == start).findFirst().get();
        UCS_NODE ucsStartNode = new UCS_NODE();
        ucsStartNode.cost = 0;
        ucsStartNode.value = startNode.value();
        cost.set(1, 0);
        cost.add(Integer.MAX_VALUE);
        priorityQueue.add(ucsStartNode);
        visited.add(startNode.value());

        while (true) {
            if (priorityQueue.isEmpty()) {
                break;
            }

            UCS_NODE ucscurrent = priorityQueue.poll();
            Node current = graph.stream().filter(n -> n.value() == ucscurrent.value).findFirst().get();
            if (current.value() == goalState) {
                break;
            }

            for (Edge currentNodeEdges : current.neighbourNodes()) {
                int child = currentNodeEdges.dest();
                if (cost.get(child) > cost.get(current.value()) + currentNodeEdges.weight()) {
                    cost.set(child, cost.get(current.value()) + currentNodeEdges.weight());

                    UCS_NODE ucsNode = new UCS_NODE();
                    ucsNode.cost = cost.get(child);
                    ucsNode.value = child;
                    addToQueue(ucsNode);
                    this.traversalStepResults.add(new TraversalStepResult(
                            new State(ucsNode.getValue(), NodeColor.RED),
                            new ArrayDeque<Integer>(priorityQueue.stream().map(n -> n.value).toList())
                    ));
                    parent.set(child, current.value());

                }
            }
            this.traversalStepResults.add(new TraversalStepResult(
                    new State(current.value(), NodeColor.GREEN),
                    new ArrayDeque<Integer>(priorityQueue.stream().map(n -> n.value).toList())
            ));
        }

        Integer nd = 6;
        Deque<Integer> path = new ArrayDeque<>();
        while (nd != Integer.MAX_VALUE) {
            path.addFirst(nd);
            nd = parent.get(nd);
        }

        System.out.println(path);
    }

    private void addToQueue(UCS_NODE ucsNode) {
        boolean isAlredyToQueue = false;
        for (UCS_NODE curr : priorityQueue) {
            if (curr.value == ucsNode.value) {
                curr.cost = ucsNode.cost;
                isAlredyToQueue = true;
                break;
            }
        }

        if (!isAlredyToQueue) {
            priorityQueue.add(ucsNode);
        }
    }

    @Override
    public TraversalStepResult getNextState(int index) {
        return this.traversalStepResults.get(index);
    }

    public static class UCS_NODE implements Comparable<UCS_NODE> {
        public int value;
        public int cost;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public int compareTo(UCS_NODE o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
