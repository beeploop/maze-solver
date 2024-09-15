package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Config;
import service.ImageConverter;

public class SetupGUI extends JFrame implements ActionListener {
    Config config;
    JButton startBtn;
    JButton openBtn;

    public SetupGUI() {
        super("Maze Solver");
        config = Config.getInstance();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(config.SCRN_SIZE, config.SCRN_SIZE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        addComponents();
    }

    private void addComponents() {
        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MazeGUI();
                dispose();
            }
        });

        openBtn = new JButton("select map");
        openBtn.addActionListener(this);

        add(startBtn);
        add(openBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openBtn) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                String selected = fc.getSelectedFile().getAbsolutePath();
                ImageConverter converter = new ImageConverter(selected);
                char[][] maze = converter.convert();
                config.setMaze(maze);

                JOptionPane.showMessageDialog(this, "Successfully loaded map from image");
            }
        }
    }
}
