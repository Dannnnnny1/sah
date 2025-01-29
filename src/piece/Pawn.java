package piece;

public class Pawn extends Piece{
    public Pawn(int x,int y,int color) {
        super(x, y, color);
        if (color == 0) {
            image = getImage("/res/piece/pawn-w");
        }
        else {
            image = getImage("/res/piece/pawn-b");
        }
    }


}
