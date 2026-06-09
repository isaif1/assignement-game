package com.gameoflife.game;

import com.gameoflife.display.GridDisplay;
import com.gameoflife.model.CellState;
import com.gameoflife.model.Grid;
import com.gameoflife.model.Position;
import com.gameoflife.pattern.Pattern;
import com.gameoflife.rules.StandardRuleEngine;

// Main simulation class - ties together the grid, rules, and display
public class GameOfLife {

    private Grid grid;
    private final StandardRuleEngine ruleEngine;
    private final GridDisplay display;
    private int generation;

    public GameOfLife(int rows, int columns, StandardRuleEngine ruleEngine, GridDisplay display) {
        this.grid = new Grid(rows, columns);
        this.ruleEngine = ruleEngine;
        this.display = display;
        this.generation = 0;
    }

    public void seedPattern(Pattern pattern) {
        pattern.placeOn(grid);
    }

    // runs the simulation for given number of generations with a small delay between each
    public void run(int generations) {
        display.render(grid, generation);

        for (int i = 0; i < generations; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            tick();
            display.render(grid, generation);
        }
    }

    // computes the next generation by applying rules to every cell at once
    public void tick() {
        Grid nextGrid = new Grid(grid.getRows(), grid.getColumns());

        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getColumns(); col++) {
                Position pos = new Position(row, col);
                CellState current = grid.getCellState(pos);
                int neighbors = grid.countAliveNeighbors(pos);

                CellState next = ruleEngine.evaluateNextState(current, neighbors);
                nextGrid.setCellState(pos, next);
            }
        }

        grid = nextGrid;
        generation++;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getGeneration() {
        return generation;
    }
}
