import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Panel extends JPanel {
    Maze maze;
    final int width = 400;
    final int height = 400;

    Panel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);

        maze = new Maze(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        maze.draw(g2d);
    }
}
