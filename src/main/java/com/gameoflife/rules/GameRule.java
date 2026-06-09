package com.gameoflife.rules;

import com.gameoflife.model.CellState;

// Each rule checks if it applies to a cell and returns the next state.
// Returns null if this particular rule doesn't apply.
public interface GameRule {

    CellState apply(CellState currentState, int aliveNeighbors);
}
