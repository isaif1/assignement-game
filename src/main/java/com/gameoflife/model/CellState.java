package com.gameoflife.model;

public enum CellState {
    ALIVE,
    DEAD;

    public boolean isAlive() {
        return this == ALIVE;
    }
}
