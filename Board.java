public class Board {
    private Square[] spaces;
    private Piece empty_piece = new Piece();

    public Board() {
        spaces = new Square[64];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                spaces[y*8+x] = new Square(x, y, empty_piece);
            }
        }

        for (int x = 0; x < 8; x++) {
            spaces[1*8+x].addPiece(new Piece(PieceType.Pawn, PieceColor.Black));
            spaces[6*8+x].addPiece(new Piece(PieceType.Pawn, PieceColor.White));
        }

        spaces[0].addPiece(new Piece(PieceType.Rook, PieceColor.Black));
        spaces[1].addPiece(new Piece(PieceType.Knight, PieceColor.Black));
        spaces[2].addPiece(new Piece(PieceType.Bishop, PieceColor.Black));
        spaces[3].addPiece(new Piece(PieceType.Queen, PieceColor.Black));
        spaces[4].addPiece(new Piece(PieceType.King, PieceColor.Black));
        spaces[5].addPiece(new Piece(PieceType.Bishop, PieceColor.Black));
        spaces[6].addPiece(new Piece(PieceType.Knight, PieceColor.Black));
        spaces[7].addPiece(new Piece(PieceType.Rook, PieceColor.Black));
 
        spaces[7*8].addPiece(new Piece(PieceType.Rook, PieceColor.White));
        spaces[7*8+1].addPiece(new Piece(PieceType.Knight, PieceColor.White));
        spaces[7*8+2].addPiece(new Piece(PieceType.Bishop, PieceColor.White));
        spaces[7*8+3].addPiece(new Piece(PieceType.King, PieceColor.White));
        spaces[7*8+4].addPiece(new Piece(PieceType.Queen, PieceColor.White));
        spaces[7*8+5].addPiece(new Piece(PieceType.Bishop, PieceColor.White));
        spaces[7*8+6].addPiece(new Piece(PieceType.Knight, PieceColor.White));
        spaces[7*8+7].addPiece(new Piece(PieceType.Rook, PieceColor.White));  
    }

    public boolean isPieceAt(int x, int y) {
        return (spaces[y*8+x].piece.type != PieceType.None);
    }

    public Square[] getSquares() {
        return spaces;
    }

    public Square getSquareAt(int x, int y) {
        return spaces[y*8+x];
    }
    
    public void movePiece(int start_x, int start_y, int end_x, int end_y) {
        if (spaces[end_y*8+end_x].piece.type == PieceType.None) {
            spaces[end_y*8+end_x].piece = spaces[start_y*8+start_x].piece;
            removePiece(start_x, start_y);
        }
    }

    public Piece getPieceAt(int x, int y) {
        return spaces[y*8+x].piece;
    }

    public void removePiece(int x, int y) {
        spaces[y*8+x].piece = empty_piece;
    }

}
