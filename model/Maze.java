package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Maze implements Drawable {
    public final Color WALL_COLOR = Color.BLACK;
    public final Color PATH_COLOR = Color.WHITE;
    private char[][] maze;
    private int tileSize;

    public final char[][] DEFAULT_MAZE = new char[][] {
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
            { '#', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '#' },
            { '#', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#' },
            { '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#' },
            { '#', '.', '#', '.', '#', '#', '#', '#', '.', '#', '#', '#' },
            { '#', '.', '#', '.', '#', '.', '#', '.', '.', '.', '#', '#' },
            { '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#', '#' },
            { '#', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#' },
            { '#', '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '#' },
            { '#', '.', '.', '.', '.', '.', '#', '.', '#', '.', '#', '#' },
            { '#', '.', '#', '#', '#', '#', '#', '.', '#', '.', '#', '#' },
            { '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#' },
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
    };

    public Maze(int SCRN_SIZE) {
        this.maze = DEFAULT_MAZE;
        this.tileSize = SCRN_SIZE / DEFAULT_MAZE.length;
    }

    public Maze(char[][] maze, int tileSize) {
        this.maze = maze;
        this.tileSize = tileSize;
    }

    @Override
    public void draw(Graphics2D g) {
        for (int row = 0; row < maze.length - 1; row++) {
            for (int col = 0; col < maze[row].length; col++) {

                if (maze[col][row] == '#') {
                    g.setPaint(WALL_COLOR);
                } else if (maze[col][row] == '.') {
                    g.setPaint(PATH_COLOR);
                }

                int originX = row * tileSize;
                int originY = col * tileSize;
                g.fillRect(originX, originY, tileSize, tileSize);
            }
        }
    }

    public void showGrid(Graphics2D g) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[col][row] == '#') {
                    continue;
                }

                int originX = row * tileSize;
                int originY = col * tileSize;
                g.drawRect(originX, originY, tileSize, tileSize);
            }
        }
    }

    public char[][] getMaze() {
        return maze;
    }

    public int getTileSize() {
        return tileSize;
    }
}
