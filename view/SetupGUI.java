package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Config;
import service.ImageConverter;

public class SetupGUI extends JFrame implements ActionListener {
    Config config;
    JButton startBtn;
    JButton openBtn;
    JLabel preview;

    public SetupGUI() {
        super("Maze Solver");
        config = Config.getInstance();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(config.SCRN_SIZE, config.SCRN_SIZE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

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
        startBtn.setBounds(10, 10, 150, 50);
        add(startBtn);

        openBtn = new JButton("select map");
        openBtn.addActionListener(this);
        openBtn.setBounds(10, 70, 150, 50);
        add(openBtn);

        String previewMsg = "Preview of selected map";
        preview = new JLabel(previewMsg, JLabel.CENTER);
        int prevWidth = config.SCRN_SIZE - 180;
        preview.setBounds(170, 10, prevWidth, prevWidth);
        preview.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(preview);

        String txt = "<html>Select an image of a maze to use. If no image is selected, default map will be used.</html>";
        JLabel text = new JLabel(txt);
        text.setBounds(10, prevWidth + 20, config.SCRN_SIZE - 20, config.SCRN_SIZE - prevWidth - 70);
        text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(text);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == openBtn) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                String selected = fc.getSelectedFile().getAbsolutePath();

                ImageConverter converter = new ImageConverter(selected);
                try {
                    converter.loadImage();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to load image", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                char[][] maze = converter.convert();
                config.setMaze(maze);

                BufferedImage image;
                try {
                    image = converter.getImage();
                } catch (Exception err) {
                    err.printStackTrace();
                    JOptionPane.showMessageDialog(this, "No image loaded", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                setPreviewImage(image);

                JOptionPane.showMessageDialog(this, "Successfully loaded map from image");
            }
        }
    }

    public void setPreviewImage(BufferedImage image) {
        Dimension dimensions = preview.getSize();
        int width = (int) dimensions.getWidth();
        int height = (int) dimensions.getHeight();
        Image icon = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        preview.setIcon(new ImageIcon(icon));
        preview.setText(null);
    }
}
