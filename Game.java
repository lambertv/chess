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
        possible_moves = new LinkedList<Move>();
    }

    public Board getBoard() {
        return board;
    }

    public void updatePossibleMoves() {
        switch (selected_piece.type) {
            case Pawn:
                //get pawn moves
                break;
            case Rook:
                //get rook moves
                break;
            case Knight:
                //get knight moves
                break;
            case Bishop:
                //get bishop moves
                break;
            case King:
                //get king moves
                break;
            case Queen:
                //get queen moves
                break;
            default:
                //no moves
                break;
        }
        return;
    }

    public void setSelectedPiece(int x, int y) {
        selected_piece = board.getPieceAt(x, y);
    }

    public void deselectPiece() {
        selected_piece = null;
    }

    public boolean pieceSelected() {
        return (selected_piece != null);
    }

    public void setSelectedMove(int x, int y) {
        for (Move move : possible_moves) {
            if (move.end_x == x && move.end_y == y) {
                selected_move = move;
            }
        }
    }

    public void deselectMove() {
        selected_move = null;
    }

    public Move getSelectedMove() {
        return selected_move;
    }

    public void makeSelectedMove() {        
        board.removePiece(selected_move.end_x, selected_move.end_y);
        board.movePiece(selected_move.start_x, selected_move.start_y,
                        selected_move.end_x, selected_move.end_y);

        deselectPiece();
        deselectMove();
    }

    public boolean isValidMove(int end_x, int end_y) {
        //implement
        return true;
    }

    public boolean isPieceAt(int x, int y) {
        return board.isPieceAt(x,y);
    }

}
