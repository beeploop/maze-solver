package service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Drawable;

public class Canvas extends JPanel {
    private ArrayList<Drawable> drawables = new ArrayList<>();

    public Canvas(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawables.forEach(drawable -> drawable.draw(g2d));
    }

    // Order of drawing is important
    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }
}
