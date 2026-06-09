package com.gameoflife.display;

import com.gameoflife.model.CellState;
import com.gameoflife.model.Grid;
import com.gameoflife.model.Position;

// Prints the grid to console. 'O' for alive, '.' for dead.
public class ConsoleGridDisplay implements GridDisplay {

    private static final char ALIVE_CHAR = 'O';
    private static final char DEAD_CHAR = '.';

    @Override
    public void render(Grid grid, int generation) {
        StringBuilder sb = new StringBuilder();

        sb.append("Generation ").append(generation).append(":\n");
        sb.append(buildBorder(grid.getColumns()));

        for (int row = 0; row < grid.getRows(); row++) {
            sb.append('|');
            for (int col = 0; col < grid.getColumns(); col++) {
                CellState state = grid.getCellState(new Position(row, col));
                sb.append(state.isAlive() ? ALIVE_CHAR : DEAD_CHAR);
            }
            sb.append("|\n");
        }

        sb.append(buildBorder(grid.getColumns()));
        System.out.println(sb);
    }

    private String buildBorder(int width) {
        StringBuilder border = new StringBuilder("+");
        for (int i = 0; i < width; i++) {
            border.append('-');
        }
        border.append("+\n");
        return border.toString();
    }
}
