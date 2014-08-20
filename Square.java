public class Square {
    public int x;
    public int y;
    public Piece piece;

    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public void addPiece(Piece piece) {
        this.piece = piece;
    }

    public String toString() {
        return (piece.type.toString() + " at (" + x + ", " + y + ")");
    }

}
