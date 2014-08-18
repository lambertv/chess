import java.util.Collection;

public class Piece {
    public PieceType type;
    public PieceColor color;

    public Piece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public Piece() {
        type = PieceType.None;
        color = PieceColor.None;
    }

}
