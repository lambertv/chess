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
        int x = selected_square.x;
        int y = selected_square.y;
        switch (selected_square.piece.type) {
            case Pawn:
                int direction = (selected_square.piece.color == PieceColor.Black) ? 1 : -1; 
                if (board.getSquareAt(x+1, y+direction).piece.type != PieceType.None &&
                    board.getSquareAt(x+1, y+direction).piece.color != selected_square.piece.color) {
                    possible_moves.add(new Move(x,y,x+1,y+direction));
                }
                if (board.getSquareAt(x-1,y+direction).piece.type != PieceType.None &&
                    board.getSquareAt(x-1,y+direction).piece.color != selected_square.piece.color) {
                    possible_moves.add(new Move(x,y,x-1,y+direction));
                }
                if (board.getSquareAt(x,y+direction).piece.type == PieceType.None) {
                    possible_moves.add(new Move(x,y,x,y+direction));
                    if (board.getSquareAt(x,y+direction).piece.type == PieceType.None &&
                        selected_square.piece.is_first_move) {
                        possible_moves.add(new Move(x,y,x,y+2*direction));
                    }
                }
                break;
            case Rook:
                int count = 1;
                PieceColor color = selected_square.piece.color;
                while (x+count < 8 && board.getSquareAt(x+count,y).piece.color != color) {
                    possible_moves.add(new Move(x,y,x+count,y));
                    if (board.getSquareAt(x+count,y).piece.type != PieceType.None) {
                        count = 8;
                    }
                    count++;
                }
                count = 1;
                while (x-count >= 0 && board.getSquareAt(x-count,y).piece.color != color) {
                    possible_moves.add(new Move(x,y,x-count,y));
                    if (board.getSquareAt(x-count,y).piece.type != PieceType.None) {
                        count = 8;
                    }
                    count++;
                }
                count = 1;
                while (y+count < 8 && board.getSquareAt(x,y+count).piece.color != color) {
                    possible_moves.add(new Move(x,y,x,y+count));
                    if (board.getSquareAt(x,y+count).piece.type != PieceType.None) {
                        count = 8;
                    }
                    count++;
                }
                count = 1;
                while (y-count >= 0 && board.getSquareAt(x,y-count).piece.color != color) {
                    possible_moves.add(new Move(x,y,x,y-count));
                    if (board.getSquareAt(x,y-count).piece.type != PieceType.None) {
                        count = 8;
                    }
                    count++;
                }
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

    public LinkedList<Move> getPossibleMoves() {
        return possible_moves;
    }

    public void makeSelectedMove() {        
        selected_square.piece.is_first_move = false;
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
