package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic;

import java.util.LinkedList;

public record Node(NodeDetails node, LinkedList<Edge> neighbourNodes) {
}
