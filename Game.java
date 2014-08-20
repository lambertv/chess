import java.util.LinkedList;

public class Game {
    private Board board;
    private PieceColor turn;
    private LinkedList<Move> possible_moves;
    private Square selected_square;
    private Move selected_move;

    public Game() {
        board = new Board();
        turn = PieceColor.White;
        possible_moves = new LinkedList<Move>();
        printBoard();
    }

    public Board getBoard() {
        return board;
    }

    public void updatePossibleMoves() {
        switch (selected_square.piece.type) {
            case Pawn:
                possible_moves.add(new Move(selected_square.x, selected_square.y, selected_square.x, selected_square.y+1));
                possible_moves.add(new Move(selected_square.x, selected_square.y, selected_square.x, selected_square.y-1));
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
        System.out.println("Created new movelist: ");
        for (Move move : possible_moves) {
            System.out.println(move.toString());
        }
        return;
    }

    public void setSelectedPiece(int x, int y) {
        selected_square = board.getSquareAt(x, y);
        System.out.printf("Selected Piece at %d, %d\n", x, y);
        updatePossibleMoves();
    }

    public void deselectPiece() {
        selected_square = null;
        possible_moves.clear();
        System.out.println("Deselected Piece");
    }

    public boolean pieceSelected() {
        return (selected_square != null);
    }

    public void setSelectedMove(int x, int y) {
        for (Move move : possible_moves) {
            if (move.end_x == x && move.end_y == y) {
                selected_move = move;
                System.out.println("Selected move: " + selected_move.toString());
            }
        }
    }

    public void deselectMove() {
        selected_move = null;
        System.out.println("Move deselected");
    }

    public Move getSelectedMove() {
        return selected_move;
    }

    public void makeSelectedMove() {        
        board.removePiece(selected_move.end_x, selected_move.end_y);
        board.movePiece(selected_move.start_x, selected_move.start_y,
                        selected_move.end_x, selected_move.end_y);
        System.out.println("Made selected move");
        printBoard();
        deselectPiece();
        deselectMove();
    }

    public boolean isPieceAt(int x, int y) {
        return board.isPieceAt(x,y);
    }
    
    public void printBoard() {
        for (Square space : board.getSquares()) {
            if (space.piece.type != PieceType.None) {
                System.out.println(space.toString());
            }
        }
    }
}
