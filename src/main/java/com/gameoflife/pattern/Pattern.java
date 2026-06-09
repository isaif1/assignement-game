package com.gameoflife.pattern;

import com.gameoflife.model.Grid;

// A seed pattern that can be placed on a grid (Glider, Blinker, etc.)
public interface Pattern {

    void placeOn(Grid grid);

    String getName();
}
