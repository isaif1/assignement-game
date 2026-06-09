package com.gameoflife.pattern;

import com.gameoflife.model.CellState;
import com.gameoflife.model.Grid;
import com.gameoflife.model.Position;

/*
 * Glider pattern - moves diagonally across the grid.
 *
 *    .O.
 *    ..O
 *    OOO
 */
public class GliderPattern implements Pattern {

    // relative offsets for the 5 alive cells
    private static final int[][] GLIDER_CELLS = {
            {0, 1},
            {1, 2},
            {2, 0}, {2, 1}, {2, 2}
    };

    @Override
    public void placeOn(Grid grid) {
        // center it on the grid
        int startRow = (grid.getRows() / 2) - 1;
        int startCol = (grid.getColumns() / 2) - 1;

        for (int[] cell : GLIDER_CELLS) {
            grid.setCellState(new Position(startRow + cell[0], startCol + cell[1]), CellState.ALIVE);
        }
    }

    @Override
    public String getName() {
        return "Glider";
    }
}
