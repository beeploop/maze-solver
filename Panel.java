import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Panel extends JPanel implements Runnable {
    final int width;
    final int height;
    final int FPS = 2;

    Thread mazeThread;
    Maze maze;
    Player player;

    Panel() {
        maze = new Maze();
        player = new Player(this, maze);

        width = maze.maze.length * maze.tileSize;
        height = maze.maze[0].length * maze.tileSize;

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        maze.draw(g2d);
        player.draw(g2d);
    }

    public void startThread() {
        mazeThread = new Thread(this);
        mazeThread.start();
    }

    public void run() {
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (mazeThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();

                delta--;
            }
        }
    }

    public void update() {
        maze.update();
        player.update();
    }
}
