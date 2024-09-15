package model;

public class Config {
    private static Config instance = null;

    // DEAULTS
    public final int DEFAULT_FPS = 1;

    private int FPS;
    private int width, height, tileSize;
    private Maze maze;

    private Config() {
        FPS = DEFAULT_FPS;
        tileSize = 40;
        maze = new Maze(tileSize);
        width = maze.getMaze().length * tileSize;
        height = maze.getMaze()[0].length * tileSize;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
