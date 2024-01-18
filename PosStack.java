public class PosStack {
    Node top;
    int size;

    PosStack() {
        top = null;
        size = 0;
    }

    public void push(Node node) {
        size++;

        if (top == null) {
            top = node;
            return;
        }

        node.next = top;
        top = node;
    }

    public Node pop() {
        if (top == null) {
            return null;
        }

        size--;
        Node value = top;
        top = top.next;
        return value;
    }

    public Node peek() {
        return top;
    }

}

class Node {
    int xData;
    int yData;
    Node next;

    Node(int x, int y) {
        xData = x;
        yData = y;
        next = null;
    }
}
