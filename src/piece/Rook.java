package piece;

public class Rook extends Piece {
    public Rook(int x, int y, int color) {
        super(x, y, color);
        if (color == 0) {
            image = getImage("/res/piece/rook-w");
        } else {
            image = getImage("/res/piece/rook-b");
        }
    }
}
