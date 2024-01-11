import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.Stack;

public class Player {
    Stack<Node> visited = new Stack<Node>();
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
        g.setPaint(Color.green);
        g.fillOval(xPos * maze.tileSize, yPos * maze.tileSize, maze.tileSize, maze.tileSize);
    }

    public void update() {
        int top = maze.maze[yPos - 1][xPos];
        int right = maze.maze[yPos][xPos + 1];
        int bottom = maze.maze[yPos + 1][xPos];
        int left = maze.maze[yPos][xPos - 1];
        int curr = maze.maze[yPos][xPos];

        maze.maze[yPos][xPos] = 3;

        if (curr == 8) {
            panel.mazeThread = null;
            System.out.println("Found a route");
            printStack();
            return;
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
            System.out.println("stuck");
            Node lastPos = visited.pop();
            xPos = lastPos.xData;
            yPos = lastPos.yData;
            System.out.println("x: " + xPos);
            System.out.println("y: " + yPos);
        }

    }

    public void printStack() {
        Iterator<Node> pos = visited.iterator();
        while (pos.hasNext()) {
            Node val = pos.next();
            System.out.println("(" + val.xData + ", " + val.yData + ")");
        }
    }
}

class Node {
    int xData;
    int yData;

    Node(int x, int y) {
        xData = x;
        yData = y;
    }
}
