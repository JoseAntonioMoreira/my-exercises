package io.codeforall.bootcamp.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import io.codeforall.bootcamp.grid.Grid;
import io.codeforall.bootcamp.grid.position.GridPosition;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;

    private Rectangle canvasRectangle;

    private int cellSize = 20;

    private int cols;

    private int rows;

    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        canvasRectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        canvasRectangle.draw();
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * 
     * @return the width of the grid
     */
    public int getWidth() {
        return canvasRectangle.getWidth();
    }

    /**
     * Obtains the height of the grid in pixels
     * 
     * @return the height of the grid
     */
    public int getHeight() {
        return canvasRectangle.getHeight();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * 
     * @return the x position of the grid
     */
    public int getX() {
        return canvasRectangle.getX();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * 
     * @return the y position of the grid
     */
    public int getY() {
        return canvasRectangle.getY();
    }

    /**
     * Obtains the pixel width and height of a grid position
     * 
     * @return
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col, row, this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * 
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return row * cellSize + PADDING;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * 
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return column * cellSize + PADDING;
    }
}
