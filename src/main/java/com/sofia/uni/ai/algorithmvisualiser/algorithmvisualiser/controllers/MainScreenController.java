package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.controllers;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Traversal;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory.Algorithm;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory.GraphTraversalFactory;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainScreenController {
    private static final String NODE_PREFIX = "Node";
    private static final String EDGE_PREFIX = "Edge";

    @FXML
    public AnchorPane graphPane;

    @FXML
    public Button initGraphBtn;

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
