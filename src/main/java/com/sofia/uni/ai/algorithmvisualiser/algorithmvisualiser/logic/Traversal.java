package com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser.logic;

import java.util.Map;
import java.util.Queue;

public interface Traversal {
    Map<State, Queue<Integer>> getNextState(int index);
}
