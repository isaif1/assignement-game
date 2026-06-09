package com.gameoflife.display;

import com.gameoflife.model.Grid;

// Interface for rendering the grid - makes it easy to swap console for something else later
public interface GridDisplay {

    void render(Grid grid, int generation);
}
