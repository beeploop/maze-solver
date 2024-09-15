package model;

public class Node {
    int xData;
    int yData;
    Node next;

    public Node(int x, int y) {
        xData = x;
        yData = y;
        next = null;
    }

    public int getX() {
        return xData;
    }

    public int getY() {
        return yData;
    }

    public boolean equals(Node node) {
        return xData == node.getX() && yData == node.getY();
    }
}
