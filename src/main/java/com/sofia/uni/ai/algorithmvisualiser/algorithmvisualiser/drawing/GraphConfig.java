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
            new TextLayoutDetails(220d, 52d, "A", 17.414215087890625d, 28),
            new TextLayoutDetails(117d, 113d, "B", 17.414215087890625d, 28),
            new TextLayoutDetails(256d, 115d, "C", 17.414215087890625d, 28),
            new TextLayoutDetails(405d, 115d, "D", 17.414215087890625d, 28),
            new TextLayoutDetails(77d, 199d, "E", 17.414215087890625d, 28),
            new TextLayoutDetails(157d, 199d, "F", 17.414215087890625d, 28),
            new TextLayoutDetails(242d, 199d, "G", 17.414215087890625d, 28),
            new TextLayoutDetails(323d, 199d, "H", 17.414215087890625d, 28),
            new TextLayoutDetails(413d, 195d, "I", 17.414215087890625d, 28),
            new TextLayoutDetails(84d, 288d, "J", 17.414215087890625d, 28)
    );

    public static final List<NodeDetails> MOUNTAIN_GRAPH_NODE_DETAILS = List.of(
            new NodeDetails(32.0, 26.0, "Node13"),
            new NodeDetails(106.0, 69.0, "Node1"),
            new NodeDetails(57.0, 136.0, "Node2"),
            new NodeDetails(87.0, 233.0, "Node4"),
            new NodeDetails(173.0, 315.0, "Node8"),
            new NodeDetails(264.0, 241.0, "Node7"),
            new NodeDetails(343.0, 167.0, "Node6"),
            new NodeDetails(283.0, 107.0, "Node5"),
            new NodeDetails(192.0, 98.0, "Node3"),
            new NodeDetails(325.0, 28.0, "Node9"),
            new NodeDetails(399.0, 88.0, "Node10"),
            new NodeDetails(414.0, 222.0, "Node11"),
            new NodeDetails(452.0, 306.0, "Node12")
    );

    public static final List<EdgeDetails> MOUNTAIN_GRAPH_EDGE_DETAILS = List.of(
            new EdgeDetails(-17.7, -20.1, 69.0, 61.0, 15.3, -2.0, "Edge1_13_3"),
            new EdgeDetails(-8.8, 45.3, 79.0, 71.0, 12.4, 16.2, "Edge1_2_2"),
            new EdgeDetails(68.1, 28.0, 59.0, 51.0, 110.7, 40.8, "Edge1_3_3"),
            new EdgeDetails(-25.2, 77.1, 89.0, 81.0, -11.0, 130.1, "Edge2_4_4"),
            new EdgeDetails(55.0, 210.4, 99.0, 91.0, 0.9, 161.6, "Edge4_8_4"),
            new EdgeDetails(85.3, 202.9, 109.0, 101.0, 139.0, 157.1, "Edge7_8_3"),
            new EdgeDetails(161.4, 113.1, 119.0, 111.0, 207.7, 73.0, "Edge6_7_3"),
            new EdgeDetails(147.0, 41.7, 69.0, 61.0, 190.0, 44.2, "Edge3_5_2"),
            new EdgeDetails(236.4, -21.6, 79.0, 71.0, 214.5, 14.8, "Edge5_9_3"),
            new EdgeDetails(287.5, 11.7, 89.0, 81.0, 218.0, 26.0, "Edge5_10_3"),
            new EdgeDetails(225.1, 61.7, 99.0, 91.0, 198.8, 34.5, "Edge5_6_2"),
            new EdgeDetails(232.3, 61.6, 129.0, 121.0, 266.4, 86.3, "Edge6_11_2"),
            new EdgeDetails(302.6, 153.7, 139.0, 131.0, 286.1, 112.5, "Edge11_12_2")
    );

    public static final List<TextLayoutDetails> MOUNTAIN_GRAPH_TEXT_LABELS = List.of(
            new TextLayoutDetails(150d, 77d, "3", 17.414215087890625d, 16),
            new TextLayoutDetails(67d, 46d, "3", 17.414215087890625d, 16),
            new TextLayoutDetails(67d, 98d, "2", 17.414215087890625d, 16),
            new TextLayoutDetails(59d, 196d, "4", 17.414215087890625d, 16),
            new TextLayoutDetails(114d, 290d, "4", 17.414215087890625d, 16),
            new TextLayoutDetails(221d, 295d, "3", 17.414215087890625d, 16),
            new TextLayoutDetails(306d, 217d, "3", 17.414215087890625d, 16),
            new TextLayoutDetails(377d, 188d, "2", 17.414215087890625d, 16),
            new TextLayoutDetails(420d, 272d, "2", 17.414215087890625d, 16),
            new TextLayoutDetails(232d, 98d, "2", 17.414215087890625d, 16),
            new TextLayoutDetails(293d, 69d, "3", 17.414215087890625d, 16),
            new TextLayoutDetails(329d, 98d, "3", 17.414215087890625d, 16),
            new TextLayoutDetails(315d, 133d, "2", 17.414215087890625d, 16),

            new TextLayoutDetails(25d, 35d, "Z", 17.414215087890625d, 28),
            new TextLayoutDetails(100d, 75d, "S", 17.414215087890625d, 28),
            new TextLayoutDetails(48d, 145d, "A", 17.414215087890625d, 28),
            new TextLayoutDetails(81d, 243d, "C", 17.414215087890625d, 28),
            new TextLayoutDetails(165d, 321d, "G", 17.414215087890625d, 28),
            new TextLayoutDetails(183d, 107d, "F", 17.414215087890625d, 28),
            new TextLayoutDetails(274d, 118d, "1", 17.414215087890625d, 28),
            new TextLayoutDetails(254d, 250d, "2", 17.414215087890625d, 28),
            new TextLayoutDetails(334d, 177d, "3", 17.414215087890625d, 28),
            new TextLayoutDetails(317d, 37d, "4", 17.414215087890625d, 28),
            new TextLayoutDetails(390d, 96d, "5", 17.414215087890625d, 28),
            new TextLayoutDetails(407d, 230d, "6", 17.414215087890625d, 28),
            new TextLayoutDetails(442d, 314d, "7", 17.414215087890625d, 28)
    );

    public static final List<NodeDetails> UCS_GRAPH_NODE_DETAILS = List.of(
            new NodeDetails(81.0, 265.0, "Node1"),
            new NodeDetails(240.0, 306.0, "Node2"),
            new NodeDetails(176.0, 177.0, "Node3"),
            new NodeDetails(105.0, 81.0, "Node4"),
            new NodeDetails(367.0, 139.0, "Node5"),
            new NodeDetails(296.0, 47.0, "Node6")
    );

    public static final List<EdgeDetails> UCS_GRAPH_EDGE_DETAILS = List.of(
            new EdgeDetails(55d, 69, 161d, 237d, -56d, 38d, "Edge1_2_7"),
            new EdgeDetails(6d, -35d, 151d, 227d, -53d, 22d, "Edge1_3_9"),
            new EdgeDetails(185d, -109d, -89d, 211d, 171d, 30d, "Edge1_4_14"),
            new EdgeDetails(255d, -20d, -71d, 220d, 310d, 63d, "Edge2_3_10"),
            new EdgeDetails(440d, -58d, -91d, 216d, 337d, 66d, "Edge2_5_15"),
            new EdgeDetails(199d, -122d, -83d, 222d, 239d, -62d, "Edge3_4_2"),
            new EdgeDetails(422d, -73d, -77d, 218d, 279d, -39d, "Edge3_5_11"),
            new EdgeDetails(351d, -167d, -81d, 219d, 210d, -144d, "Edge4_6_9"),
            new EdgeDetails(390d, -156d, -79d, 224d, 432d, -100, "Edge5_6_6")
    );

    public static final List<TextLayoutDetails> UCS_GRAPH_TXT_LAYOUT_DETAILS = List.of(
            new TextLayoutDetails(143d, 310d, "7", 0d, 16),
            new TextLayoutDetails(212d, 234d, "10", 0d, 16),
            new TextLayoutDetails(312d, 246d, "15", 0d, 16),
            new TextLayoutDetails(112d, 215d, "9", 0d, 16),
            new TextLayoutDetails(144d, 127d, "2", 0d, 16),
            new TextLayoutDetails(57d, 177d, "14", 0d, 16),
            new TextLayoutDetails(192d, 51d, "9", 0d, 16),
            new TextLayoutDetails(264d, 157d, "11", 0d, 16),
            new TextLayoutDetails(335d, 85d, "6", 0d, 16),
            new TextLayoutDetails(72d, 274d, "A", 0d, 28),
            new TextLayoutDetails(231d, 316d, "B", 0d, 28),
            new TextLayoutDetails(167d, 186d, "C", 0d, 28),
            new TextLayoutDetails(96d, 90d, "D", 0d, 28),
            new TextLayoutDetails(356d, 148d, "E", 0d, 28),
            new TextLayoutDetails(287d, 55d, "F", 0d, 28)
    );
}
