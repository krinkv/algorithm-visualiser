package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.controllers;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.State;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Traversal;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.TraversalStepResult;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory.Algorithm;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory.GraphTraversalFactory;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class MainScreenController {
    private static final String NODE_PREFIX = "Node";
    private static final String EDGE_PREFIX = "Edge";

    private int step = 0;

    @FXML
    public AnchorPane graphPane;

    @FXML
    public Button initGraphBtn;

    @FXML
    public Button nextStateBtn;

    private Traversal traversal;

    @FXML
    public void initGraphAction() {
        traversal = GraphTraversalFactory.constructGraph(
                graphPane.getChildren()
                        .filtered(n -> n.getId().contains(NODE_PREFIX))
                        .stream()
                        .map(Node::getId)
                        .map(this::getNodeNum)
                        .collect(Collectors.toList()),
                graphPane.getChildren()
                        .filtered(n -> n.getId().contains(EDGE_PREFIX))
                        .stream()
                        .map(Node::getId)
                        .map(this::getSourceDestinationEdge)
                        .collect(Collectors.toList()),
                Algorithm.BFS   // Hard coded for now
        );
    }

    @FXML
    public void nextStateAction() {
        TraversalStepResult currentState = traversal.getNextState(step);

        Shape node = (Shape) graphPane.getChildren()
                .filtered(n -> NODE_PREFIX.concat(String.valueOf(currentState.state().getValue())).equals(n.getId()))
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Failed to obtain new state"));

        node.setFill(Color.valueOf(currentState.state().getNodeColor().name()));
        step++;
    }

    private Integer getNodeNum(String nodeId) {
        return Integer.valueOf(nodeId.substring(NODE_PREFIX.length()));
    }

    private Edge getSourceDestinationEdge(String edgeId) {
        List<Integer> sourceDest = Arrays
                .stream(edgeId.substring(EDGE_PREFIX.length()).split("_"))
                .map(Integer::valueOf)
                .toList();

        return new Edge(
                sourceDest.get(0),
                sourceDest.get(1)
        );
    }
}
