package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.controllers;

import java.util.Arrays;
import java.util.Optional;

public enum NodeLabel {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8),
    I(9),
    J(10),
    K(11),
    L(12),
    M(13);

    private final int index;

    NodeLabel(int index) {
        this.index = index;
    }

    public int getIndex() {
       return this.index;
    }

    public static Optional<NodeLabel> getNodeLabel(int index) {
        return Arrays.stream(NodeLabel.values())
                .filter(n -> n.getIndex() == index)
                .findFirst();
    }
}
