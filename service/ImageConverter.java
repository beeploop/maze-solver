package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import model.Config;

public class ImageConverter {
    Config config;
    String imagePath;

    public ImageConverter(String imagePath) {
        config = Config.getInstance();
        this.imagePath = imagePath;
    }

    public char[][] convert() {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
