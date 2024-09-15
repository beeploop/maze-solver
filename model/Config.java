package model;

import java.awt.Color;

public class Config {
    private static Config instance = null;

    // DEAULTS
    public final int DEFAULT_FPS = 2;
    public final int SCRN_SIZE = 600;

    private int FPS;
    private Maze maze;
    public Color wallColor;
    public Color pathColor;

    private Config() {
        FPS = DEFAULT_FPS;
        maze = new Maze(SCRN_SIZE);
        wallColor = Color.BLACK;
        pathColor = Color.WHITE;
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int fPS) {
        FPS = fPS;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(char[][] maze) {
        int tileSize = SCRN_SIZE / maze.length;
        Maze m = new Maze(maze, tileSize);
        this.maze = m;
    }
}
