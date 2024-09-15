package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player implements Drawable {
    Config config;
    Node pos;
    Color color;

    public Player() {
        config = Config.getInstance();

        pos = new Node(1, 1);
        color = Color.ORANGE;
    }

    public void draw(Graphics2D g) {
        int posX = pos.getX() * config.getTileSize();
        int posY = pos.getY() * config.getTileSize();
        g.setPaint(color);
        g.fillOval(posX, posY, config.getTileSize(), config.getTileSize());
    }

    public Color getColor() {
        return color;
    }

    public Node getPos() {
        return pos;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void move(Node pos) {
        this.pos = pos;
    }
}
