import javax.swing.JFrame;

public class Runner extends JFrame {

    Panel panel;

    Runner() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Runner");

        panel = new Panel();
        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel.startThread();
    }

    public static void main(String[] args) {
        new Runner();
    }
}
