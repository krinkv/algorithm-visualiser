package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.controllers;

import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.drawing.GraphDrawer;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Edge;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.NodeDetails;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.Traversal;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.TraversalStepResult;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory.Algorithm;
import com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic.factory.GraphTraversalFactory;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Queue;
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

    @FXML
    public RadioButton bfsRbtn;

    @FXML
    public RadioButton dfsRbtn;

    @FXML
    public RadioButton ucsRbtn;

    @FXML
    public RadioButton greedyRbtn;

    @FXML
    public AnchorPane dataStructurePane;

    private Traversal traversal;

    @FXML
    public void initGraphAction() {
        step = 0;
        traversal = GraphTraversalFactory.constructGraph(
                graphPane.getChildren()
                        .filtered(n -> n.getId() != null)
                        .filtered(n -> n.getId().contains(NODE_PREFIX))
                        .stream()
                        .map(Node::getId)
                        .map(this::getNodeNum)
                        .collect(Collectors.toList()),
                graphPane.getChildren()
                        .filtered(n -> n.getId() != null)
                        .filtered(n -> n.getId().contains(EDGE_PREFIX))
                        .stream()
                        .map(Node::getId)
                        .map(this::getSourceDestinationEdge)
                        .flatMap(List::stream)
                        .collect(Collectors.toList()),
                getAlgorithm()
        );
    }

    private Algorithm getAlgorithm() {
        if (bfsRbtn.isSelected()) {
            return Algorithm.BFS;
        } else if (dfsRbtn.isSelected()) {
            return Algorithm.DFS;
        } else if (ucsRbtn.isSelected()) {
            return Algorithm.UCS;
        } else if (greedyRbtn.isSelected()) {
            return Algorithm.GREEDY;
        }

        return null;
    }

    @FXML
    public void selectAlgorithm() {
        graphPane.getChildren().clear();

        if (bfsRbtn.isSelected() || dfsRbtn.isSelected()) {
            graphPane.getChildren().addAll(GraphDrawer.drawUninformedSearchGraph());
        } else if (ucsRbtn.isSelected()) {
            graphPane.getChildren().addAll(GraphDrawer.drawUCSsearchGraph());
        } else if (greedyRbtn.isSelected()) {
            graphPane.getChildren().addAll(GraphDrawer.drawMountainSearchGraph());
        }
    }

    @FXML
    public void nextStateAction() {
        TraversalStepResult currentState = traversal.getNextState(step);

        Shape node = null;
        if (greedyRbtn.isSelected()) {
            node = (Shape) graphPane.getChildren()
                    .filtered(n -> NODE_PREFIX.concat(String.valueOf(currentState.state().getValue())).concat("_")
                            .concat(String.valueOf(currentState.state().getHeuristic()))
                            .equals(n.getId()))
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Failed to obtain new state"));
        } else {
            node = (Shape) graphPane.getChildren()
                    .filtered(n -> NODE_PREFIX.concat(String.valueOf(currentState.state().getValue())).equals(n.getId()))
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Failed to obtain new state"));
        }

        node.setFill(Color.valueOf(currentState.state().getNodeColor().name()));
        updateDataStructure(currentState.dataStructure());
        step++;
    }

    private void updateDataStructure(Queue<Integer> dataStructure) {
        dataStructurePane.getChildren().clear();
        int currentY = 560;
        int diff = 70;

        while (!dataStructure.isEmpty()) {
            int element = dataStructure.poll();
            Circle circle = createDataStructureUiElement();
            Text text = new Text(NodeLabel.getNodeLabel(element).get().toString());
            text.setBoundsType(TextBoundsType.VISUAL);
            text.setFont(new Font(28));
            StackPane dataStructEl = createStackPane(circle, text, currentY);
            currentY -= diff;
            dataStructurePane.getChildren().add(dataStructEl);
        }
    }

    private StackPane createStackPane(Circle circle, Text text, int layoutY) {
        int layoutX = 15;
        StackPane stack = new StackPane();
        stack.getChildren().addAll(circle, text);
        stack.setLayoutX(layoutX);
        stack.setLayoutY(layoutY);

        return stack;
    }

    private Circle createDataStructureUiElement() {
        Circle circle = new Circle();
        circle.setRadius(24);
        circle.setFill(Color.RED);

        return circle;
    }

    private NodeDetails getNodeNum(String nodeId) {
        List<Integer> nodeDetailsValues = Arrays
                .stream(nodeId.substring(NODE_PREFIX.length()).split("_"))
                .map(Integer::valueOf)
                .toList();

        return new NodeDetails(nodeDetailsValues.get(0), nodeDetailsValues.size() == 1 ? 1 : nodeDetailsValues.get(1));
    }

    private List<Edge> getSourceDestinationEdge(String edgeId) {
        List<Integer> sourceDestWeight = Arrays
                .stream(edgeId.substring(EDGE_PREFIX.length()).split("_"))
                .map(Integer::valueOf)
                .toList();

        return new ArrayList<Edge>(List.of(
                new Edge(sourceDestWeight.get(0), sourceDestWeight.get(1), sourceDestWeight.size() == 2 ? 1 : sourceDestWeight.get(2)),
                new Edge(sourceDestWeight.get(1), sourceDestWeight.get(0), sourceDestWeight.size() == 2 ? 1 : sourceDestWeight.get(2))
        ));
    }
}
