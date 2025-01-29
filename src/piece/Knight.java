package piece;

public class Knight extends Piece {
    public Knight(int x, int y, int color) {
        super(x, y, color);
        if (color == 0) {
            image = getImage("/res/piece/knight-w");
        } else {
            image = getImage("/res/piece/knight-b");
        }
    }
}
