package view;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;

import service.Canvas;

import model.Config;
import model.Node;
import model.Player;

public class MazeGUI extends JFrame implements Runnable {
    Thread thread;
    Config config;
    Canvas canvas;
    ArrayList<Node> visited;
    Stack<Node> path;

    Player player;

    public MazeGUI() {
        super("Maze Solver");
        config = Config.getInstance();
        visited = new ArrayList<>();
        path = new Stack<>();

        player = new Player();

        canvas = new Canvas(config.getWidth(), config.getHeight());
        canvas.addDrawable(config.getMaze());
        canvas.addDrawable(player);

        add(canvas);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        path.push(player.getPos());
        visited.add(player.getPos());
        start();
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / config.getFPS();
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                Node nextPos = findNextPosition();
                if (nextPos == null && visited.isEmpty()) {
                    thread = null;
                    System.exit(0);
                }

                if (nextPos == null) {
                    Node pos = path.pop();
                    player.move(pos);
                } else {
                    path.push(nextPos);
                    player.move(nextPos);
                }

                repaint();

                delta--;
            }
        }
    }

    public Node findNextPosition() {
        Node pos;

        char[][] maze = config.getMaze().getMaze();
        int posX = player.getPos().getX();
        int posY = player.getPos().getY();

        // Check above
        if (isPositionValid(maze, posX, posY - 1)) {
            pos = new Node(posX, posY - 1);
            visited.add(pos);
            return pos;
        }

        // Check left
        if (isPositionValid(maze, posX - 1, posY)) {
            pos = new Node(posX - 1, posY);
            visited.add(pos);
            return pos;
        }

        // Check below
        if (isPositionValid(maze, posX, posY + 1)) {
            pos = new Node(posX, posY + 1);
            visited.add(pos);
            return pos;
        }

        // Check right
        if (isPositionValid(maze, posX + 1, posY)) {
            pos = new Node(posX + 1, posY);
            visited.add(pos);
            return pos;
        }

        return null;
    }

    public boolean isPositionValid(char[][] maze, int x, int y) {
        try {
            if (maze[y][x] == '#') {
                return false;
            }

            Node pos = new Node(x, y);

            for (int i = 0; i < visited.size(); i++) {
                if (visited.get(i).equals(pos)) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
