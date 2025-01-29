package piece;

import main.Board;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Piece {
    public BufferedImage image;
    public int x;
    public int y;
    public int col,row,preCol,preRow;
    public int color;

    public  Piece(int x, int y, int color){
        this.x=x;
        this.y=y;
        this.color=color;
        x=getX(col);
        y=getY(row);
        preCol=col;
        preRow=row;
    }

    public BufferedImage getImage(String imagePath) {
        BufferedImage image=null;
        try {
            image=javax.imageio.ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath + ".svg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;

    }

    public int getX(int col){
        return col * Board.SQUARE_SIZE;
    }
    public int getY(int row){
        return row * Board.SQUARE_SIZE;
    }
    public void draw(Graphics2D g2){
        g2.drawImage(image,x,y, Board.SQUARE_SIZE, Board.SQUARE_SIZE,null);
    }
}
