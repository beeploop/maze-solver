import java.awt.Color;
import java.awt.Graphics2D;

public class Maze {
    final int maze[][] = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 5, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1 },
            { 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 8, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
    };
    final int tileSize;

    Maze() {
        tileSize = 40;
    }

    public void draw(Graphics2D g) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {

                if (maze[row][col] == 1) {
                    g.setPaint(Color.orange);
                } else if (maze[row][col] == 5) {
                    g.setPaint(Color.green);
                } else if (maze[row][col] == 8) {
                    g.setPaint(Color.red);
                } else {
                    g.setPaint(Color.white);
                }

                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                g.setPaint(Color.black);
                g.drawRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }
    }

    public void update() {

    }
}
