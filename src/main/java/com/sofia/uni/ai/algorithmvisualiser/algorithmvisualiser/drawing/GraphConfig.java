package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.drawing;

import org.w3c.dom.Text;

import java.util.List;

public class GraphConfig {
    public static final List<NodeDetails> UNINFORMED_SEARCH_GRAPH_NODE_DETAILS = List.of(
           new NodeDetails(126.0, 104.0, "Node2"),
           new NodeDetails(229.0, 43.0, "Node1"),
           new NodeDetails(86.0, 188.0, "Node5"),
           new NodeDetails(86.0, 277.0, "Node10"),
           new NodeDetails(166.0, 188.0, "Node6"),
           new NodeDetails(265.0, 104.0, "Node3"),
           new NodeDetails(251.0, 188.0, "Node7"),
           new NodeDetails(332.0, 188.0, "Node8"),
           new NodeDetails(415.0, 104.0, "Node4"),
           new NodeDetails(415.0, 184.0, "Node9")
    );

    public static final List<EdgeDetails> UNINFORMED_SEARCH_GRAPH_EDGE_DETAILS = List.of(
            new EdgeDetails(-187.0, -37.0, 273.0, 249.0, -187.0, 9.0, "Edge5_10"),
            new EdgeDetails(-171.0, -140.0, 281.0, 261.0, -187.0, -97.0, "Edge2_5"),
            new EdgeDetails(-77.0, -207.0, 282.0, 261.0, -132.0, -170.0, "Edge1_2"),
            new EdgeDetails(-144.0, -130.0, 283.0, 258.0, -126.0, -94.0, "Edge2_6"),
            new EdgeDetails(-41.0, -194.0, 283.0, 261.0, -24.0, -181.0, "Edge1_3"),
            new EdgeDetails(-24.0, -133.0, 283.0, 261.0, -31.0, -89.0, "Edge3_7"),
            new EdgeDetails(110.0, -166.0, 281.0, 261.0, -28.0, -218.0, "Edge1_4"),
            new EdgeDetails(132.0, -133.0, 283.0, 261.0, 133.0, -101.0, "Edge4_9"),
            new EdgeDetails(0.0, -141.0, 283.0, 261.0, 42.0, -97.0, "Edge3_8")
    );

    public static final List<TextLayoutDetails> UNINFORMED_SEARCH_GRAPH_TEXT_LABELS = List.of(
            new TextLayoutDetails(220d, 52d, "A"),
            new TextLayoutDetails(117d, 113d, "B"),
            new TextLayoutDetails(256d, 115d, "C"),
            new TextLayoutDetails(405d, 115d, "D"),
            new TextLayoutDetails(77d, 199d, "E"),
            new TextLayoutDetails(157d, 199d, "F"),
            new TextLayoutDetails(242d, 199d, "G"),
            new TextLayoutDetails(323d, 199d, "H"),
            new TextLayoutDetails(413d, 195d, "I"),
            new TextLayoutDetails(84d, 288d, "J")
    );
}
