package piece;

public class Bishop extends Piece {
    public Bishop(int color, int col, int row) {
        super(color, col, row);
        if (color == 0) {
            image = getImage("/piece/white-bishop.png");
        } else {
            image = getImage("/piece/black-bishop.png");
        }
    }
}
