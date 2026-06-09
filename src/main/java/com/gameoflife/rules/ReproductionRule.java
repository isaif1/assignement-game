package com.gameoflife.rules;

import com.gameoflife.model.CellState;

// dead cell with exactly 3 neighbors comes alive (reproduction)
public class ReproductionRule implements GameRule {

    @Override
    public CellState apply(CellState currentState, int aliveNeighbors) {
        if (!currentState.isAlive() && aliveNeighbors == 3) {
            return CellState.ALIVE;
        }
        return null;
    }
}
