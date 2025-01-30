package piece;

import main.Board;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Piece {
    public BufferedImage image;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        this.x = getX(col); // Calculate x position
        this.y = getY(row); // Calculate y position
        this.preCol = col;
        this.preRow = row;
    }

    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }

    public void draw(Graphics2D g2) {
        if (image != null) {
            g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
        } else {
            System.out.println("Image not loaded for piece at (" + col + ", " + row + ")");
        }
    }
}