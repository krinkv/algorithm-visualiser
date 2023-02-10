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
        List<Node> nodes = GraphConfig.UNINFORMED_SEARCH_GRAPH_NODE_DETAILS
                .stream()
                .map(GraphDrawer::createNode)
                .toList();

        List<Node> edges = GraphConfig.UNINFORMED_SEARCH_GRAPH_EDGE_DETAILS
                .stream()
                .map(GraphDrawer::createEdge)
                .toList();

        List<Node> labels = GraphConfig.UNINFORMED_SEARCH_GRAPH_TEXT_LABELS
                .stream()
                .map(GraphDrawer::createNodeLabel)
                .toList();

        return Stream.of(nodes, edges, labels)
                .flatMap(Collection::stream)
                .toList();

    }

    public static List<Node> drawMountainSearchGraph() {
        List<Node> nodes = GraphConfig.MOUNTAIN_GRAPH_NODE_DETAILS
                .stream()
                .map(GraphDrawer::createNode)
                .toList();

        List<Node> edges = GraphConfig.MOUNTAIN_GRAPH_EDGE_DETAILS
                .stream()
                .map(GraphDrawer::createEdge)
                .toList();

        List<Node> labels = GraphConfig.MOUNTAIN_GRAPH_TEXT_LABELS
                .stream()
                .map(GraphDrawer::createNodeLabel)
                .toList();

        return Stream.of(nodes, edges, labels)
                .flatMap(Collection::stream)
                .toList();

    }
    
    public static List<Node> drawUCSsearchGraph() {
        List<Node> nodes = GraphConfig.UCS_GRAPH_NODE_DETAILS
                .stream()
                .map(GraphDrawer::createNode)
                .toList();

        List<Node> edges = GraphConfig.UCS_GRAPH_EDGE_DETAILS
                .stream()
                .map(GraphDrawer::createEdge)
                .toList();


        List<Node> labels = GraphConfig.UCS_GRAPH_TXT_LAYOUT_DETAILS
                .stream()
                .map(GraphDrawer::createNodeLabel)
                .toList();

        return Stream.of(nodes, edges, labels)
                .flatMap(Collection::stream)
                .toList();

    }

    public static Node drawHeuristicDetails() {
        Text text = new Text();
        text.setLayoutX(288d);
        text.setLayoutY(446d);
        text.setText("h(A) = 8   h(B) = 7   h(C) = 5   h(D) = 4   h(E) = 6   h(F) = 6    h(G) = 3   h(H) = 0   h(I) = 9   h(J) = 9   h(K) = 7   h(L) = 8   h(M) = 11");
        text.setWrappingWidth(267.7294921875d);
        text.setFont(new Font(16d));
        text.setId("heuristic-data");
        return text;
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
        text.setFont(new Font(textLayoutDetails.fontSize()));
        text.setStrokeWidth(0d);
        text.setWrappingWidth(textLayoutDetails.wrappingWidth());

        return text;
    }
}
