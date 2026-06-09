package com.gameoflife;

import com.gameoflife.display.ConsoleGridDisplay;
import com.gameoflife.display.GridDisplay;
import com.gameoflife.game.GameOfLife;
import com.gameoflife.pattern.GliderPattern;
import com.gameoflife.pattern.Pattern;
import com.gameoflife.rules.StandardRuleEngine;

public class Main {

    private static final int GRID_SIZE = 25;
    private static final int GENERATIONS = 20;

    public static void main(String[] args) {
        StandardRuleEngine ruleEngine = new StandardRuleEngine();
        GridDisplay display = new ConsoleGridDisplay();
        Pattern pattern = new GliderPattern();

        GameOfLife game = new GameOfLife(GRID_SIZE, GRID_SIZE, ruleEngine, display);
        game.seedPattern(pattern);

        System.out.println("=== Conway's Game of Life ===");
        System.out.println("Grid: " + GRID_SIZE + "x" + GRID_SIZE);
        System.out.println("Pattern: " + pattern.getName());
        System.out.println("Generations: " + GENERATIONS);
        System.out.println();

        game.run(GENERATIONS);
    }
}
