import javax.swing.SwingUtilities;

import view.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SetupGUI().setVisible(true);
            }
        });
    }
}
