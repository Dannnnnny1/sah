package piece;

import main.GamePanel;

public class Pawn extends Piece {
    public Pawn(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/piece/white-pawn.png"); // Path for white pawn
        } else {
            image = getImage("/piece/black-pawn.png"); // Path for black pawn
        }
    }
}