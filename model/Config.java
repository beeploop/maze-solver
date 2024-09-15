package model;

public class Config {
    private static Config instance = null;

    // DEAULTS
    public final int DEFAULT_FPS = 2;
    public final int SCRN_SIZE = 600;

    private int FPS;
    private Maze maze;

    private Config() {
        FPS = DEFAULT_FPS;
        maze = new Maze(SCRN_SIZE);
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

    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
