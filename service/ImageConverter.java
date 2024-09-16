package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import model.Config;

public class ImageConverter {
    Config config;
    String imagePath;
    BufferedImage image;

    public ImageConverter(String imagePath) {
        config = Config.getInstance();
        this.imagePath = imagePath;
    }

    public void loadImage() throws Exception {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public char[][] convert() {
        int width = image.getWidth();
        int height = image.getHeight();
        char[][] maze = new char[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));

                if (c.equals(config.wallColor)) {
                    maze[i][j] = '#';
                    continue;
                }

                if (c.equals(config.pathColor)) {
                    maze[i][j] = '.';
                    continue;
                }
            }
        }

        return maze;
    }

    public BufferedImage getImage() throws Exception {
        if (image == null) {
            throw new Exception("Image not loaded");
        }

        return image;
    }
}
