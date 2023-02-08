package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic;

import java.util.Objects;

public class State {
    int value;
    NodeColor nodeColor;

    public State(int value, NodeColor nodeColor) {
        this.value = value;
        this.nodeColor = nodeColor;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeColor getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(NodeColor nodeColor) {
        this.nodeColor = nodeColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return value == state.value && nodeColor == state.nodeColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, nodeColor);
    }
}
