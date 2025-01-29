package piece;

public class King extends Piece {
    public King(int x, int y, int color) {
        super(x, y, color);
        if (color == 0) {
            image=getImage("/res/piece/king-w");
        } else {
            image = getImage("/res/piece/king-b");
        }
    }
}
