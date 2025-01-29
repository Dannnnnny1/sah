package piece;

public class Queen extends Piece {
    public Queen(int x, int y, int color) {
        super(x, y, color);
        if (color == 0) {
            image = getImage("/res/piece/queen-w");
        } else {
            image = getImage("/res/piece/queen-b");
        }
    }
}
