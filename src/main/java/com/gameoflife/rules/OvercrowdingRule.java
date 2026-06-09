package com.gameoflife.rules;

import com.gameoflife.model.CellState;

// live cell with more than 3 neighbors dies (overcrowding)
public class OvercrowdingRule implements GameRule {

    @Override
    public CellState apply(CellState currentState, int aliveNeighbors) {
        if (currentState.isAlive() && aliveNeighbors > 3) {
            return CellState.DEAD;
        }
        return null;
    }
}
