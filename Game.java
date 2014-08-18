import java.util.LinkedList;

public class Game {
    private Board board;
    private PieceColor turn;
    private LinkedList<Move> possible_moves;
    private Piece selected_piece;
    private Move selected_move;

    public Game() {
        board = new Board();
        turn = PieceColor.White;
        possible_moves = new LinkedList();
    }

    public void updatePossibleMoves() {
        switch (selected_piece.type) {
            case PieceType.Pawn:
                //get pawn moves
                break;
            case PieceType.Rook:
                //get rook moves
                break;
            case PieceType.Knight:
                //get knight moves
                break;
            case PieceType.Bishop:
                //get bishop moves
                break;
            case PieceType.King:
                //get king moves
                break;
            case PieceType.Queen:
                //get queen moves
                break;
            case default:
                //no moves
                break;
        return;
    }

    public void makeSelectedMove() {
        board.makeMove(selected_move);
    }

}
