package piece;

import main.GamePanel;

public class Rook extends Piece {
    public Rook(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/piece/white-rook.png");
        } else {
            image = getImage("/piece/black-rook.png");
        }
    }
}
