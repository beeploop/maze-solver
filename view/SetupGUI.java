package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SetupGUI extends JFrame {
    JButton button;

    public SetupGUI() {
        super("Maze Solver");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        addComponents();
    }

    private void addComponents() {
        button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MazeGUI();
                dispose();
            }
        });

        add(button);
    }
}
