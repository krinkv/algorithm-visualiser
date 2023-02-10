package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.drawing;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class GraphDrawer {
    public static List<Node> drawUninformedSearchGraph() {
        List<Node> nodes = GraphConfig.MOUNTAIN_GRAPH_NODE_DETAILS
                .stream()
                .map(GraphDrawer::createNode)
                .toList();

        List<Node> edges = GraphConfig.MOUNTAIN_GRAPH_EDGE_DETAILS
                .stream()
                .map(GraphDrawer::createEdge)
                .toList();

        List<Node> labels = GraphConfig.MOUNTAIN_GRAPH_TEXT_LABELS_EDGES
                .stream()
                .map(GraphDrawer::createNodeLabel)
                .toList();

        return Stream.of(nodes, edges, labels)
                .flatMap(Collection::stream)
                .toList();

    }

    private static Node createNode(NodeDetails details) {
        Circle circle = new Circle();
        circle.setRadius(24d);
        circle.setLayoutX(details.x());
        circle.setLayoutY(details.y());
        circle.setFill(Color.DODGERBLUE);
        circle.setStroke(Paint.valueOf("BLACK"));
        circle.setStrokeType(StrokeType.INSIDE);
        circle.setId(details.id());

        return circle;
    }

    private static Node createEdge(EdgeDetails details) {
        Line line = new Line();
        line.setEndX(details.endX());
        line.setEndY(details.endY());
        line.setLayoutX(details.layoutX());
        line.setLayoutY(details.layoutY());
        line.setStartX(details.startX());
        line.setStartY(details.startY());
        line.setId(details.id());
        line.setFill(Color.BLACK);

        return line;
    }

    private static Node createNodeLabel(TextLayoutDetails textLayoutDetails) {
        Text text = new Text();
        text.setLayoutX(textLayoutDetails.x());
        text.setLayoutY(textLayoutDetails.y());
        text.setText(textLayoutDetails.text());
        text.setFont(new Font(28d));
        text.setStrokeWidth(0d);
        text.setWrappingWidth(textLayoutDetails.wrappingWidth());

        return text;
    }
}
