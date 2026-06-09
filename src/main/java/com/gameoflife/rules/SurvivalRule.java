package com.gameoflife.rules;

import com.gameoflife.model.CellState;

// live cell with 2 or 3 neighbors survives
public class SurvivalRule implements GameRule {

    @Override
    public CellState apply(CellState currentState, int aliveNeighbors) {
        if (currentState.isAlive() && (aliveNeighbors == 2 || aliveNeighbors == 3)) {
            return CellState.ALIVE;
        }
        return null;
    }
}
