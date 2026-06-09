package com.gameoflife.model;

// Represents the 2D grid of cells. Anything outside the boundary is treated as dead.
public class Grid {

    private final int rows;
    private final int columns;
    private final CellState[][] cells;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new CellState[rows][columns];

        // start with everything dead
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                cells[r][c] = CellState.DEAD;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public CellState getCellState(Position position) {
        if (!isWithinBounds(position)) {
            return CellState.DEAD;
        }
        return cells[position.getRow()][position.getColumn()];
    }

    public void setCellState(Position position, CellState state) {
        if (isWithinBounds(position)) {
            cells[position.getRow()][position.getColumn()] = state;
        }
    }

    // counts how many of the 8 surrounding cells are alive
    public int countAliveNeighbors(Position position) {
        int count = 0;
        int row = position.getRow();
        int col = position.getColumn();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue; // skip itself

                Position neighbor = new Position(row + dr, col + dc);
                if (getCellState(neighbor).isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isWithinBounds(Position position) {
        int r = position.getRow();
        int c = position.getColumn();
        return r >= 0 && r < rows && c >= 0 && c < columns;
    }
}
