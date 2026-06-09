package com.gameoflife.rules;

import com.gameoflife.model.CellState;

// live cell with fewer than 2 neighbors dies (underpopulation)
public class UnderpopulationRule implements GameRule {

    @Override
    public CellState apply(CellState currentState, int aliveNeighbors) {
        if (currentState.isAlive() && aliveNeighbors < 2) {
            return CellState.DEAD;
        }
        return null;
    }
}
