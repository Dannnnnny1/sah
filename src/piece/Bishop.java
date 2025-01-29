package piece;

public class Bishop extends Piece {
    public Bishop(int x, int y, int color) {
        super(x, y, color);
        if (color == 0) {
            image = getImage("/res/piece/bishop-w");
        } else {
            image = getImage("/res/piece/bishop-b");
        }
    }
}
