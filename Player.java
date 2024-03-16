import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

public class Player {
    PosStack visited = new PosStack();
    Panel panel;
    Maze maze;
    int xPos, yPos;

    Player(Panel panel, Maze maze) {
        this.panel = panel;
        this.maze = maze;
        xPos = 1;
        yPos = 1;
    }

    public void draw(Graphics2D g) {
        g.setPaint(Color.blue);
        g.fillOval(xPos * maze.tileSize, yPos * maze.tileSize, maze.tileSize, maze.tileSize);
    }

    public void update() {
        normalMovement();
    }

    public void normalMovement() {
        int top = maze.maze[yPos - 1][xPos];
        int right = maze.maze[yPos][xPos + 1];
        int bottom = maze.maze[yPos + 1][xPos];
        int left = maze.maze[yPos][xPos - 1];
        int curr = maze.maze[yPos][xPos];

        maze.maze[yPos][xPos] = 3;

        if (curr == 8) {
            panel.mazeThread = null;
            JOptionPane.showMessageDialog(panel, "Found a route", "Success", JOptionPane.INFORMATION_MESSAGE);
            new RouteSaver(visited).saveRoute();
            System.exit(0);
        }

        if (top != 1 && top != 3) {
            yPos -= 1;
            Node pos = new Node(xPos, yPos);
            visited.push(pos);
        } else if (right != 1 && right != 3) {
            xPos += 1;
            Node pos = new Node(xPos, yPos);
            visited.push(pos);
        } else if (bottom != 1 && bottom != 3) {
            yPos += 1;
            Node pos = new Node(xPos, yPos);
            visited.push(pos);
        } else if (left != 1 && left != 3) {
            xPos -= 1;
            Node pos = new Node(xPos, yPos);
            visited.push(pos);
        } else {
            Node lastPos = visited.pop();
            if (lastPos == null) {
                System.out.println("no possible route found");
                JOptionPane.showMessageDialog(panel, "No possible route found", "Error", JOptionPane.ERROR_MESSAGE);
                panel.mazeThread = null;
                System.exit(0);
            }

            xPos = lastPos.xData;
            yPos = lastPos.yData;
        }
    }
}
