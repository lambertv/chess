public class Board {
    private Square[] spaces;

    public Board() {
        spaces = new Square[64];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                spaces[y*8+x] = new Square(x, y, new Piece());
            }
        }

        for (int x = 0; x < 8; x++) {
            spaces[1*8+x].addPiece(new Piece(PieceType.Pawn, PieceColor.Black));
            spaces[6*8+x].addPiece(new Piece(PieceType.Pawn, PieceColor.Black));
        }

        spaces[0].addPiece(new Piece(PieceType.Rook, PieceColor.Black));
        spaces[1].addPiece(new Piece(PieceType.Knight, PieceColor.Black));
        spaces[2].addPiece(new Piece(PieceType.Bishop, PieceColor.Black));
        spaces[3].addPiece(new Piece(PieceType.Queen, PieceColor.Black));
        spaces[4].addPiece(new Piece(PieceType.King, PieceColor.Black));
        spaces[5].addPiece(new Piece(PieceType.Bishop, PieceColor.Black));
        spaces[6].addPiece(new Piece(PieceType.Knight, PieceColor.Black));
        spaces[7].addPiece(new Piece(PieceType.Rook, PieceColor.Black));
 
        spaces[6*8].addPiece(new Piece(PieceType.Rook, PieceColor.White));
        spaces[6*8+1].addPiece(new Piece(PieceType.Knight, PieceColor.White));
        spaces[6*8+2].addPiece(new Piece(PieceType.Bishop, PieceColor.White));
        spaces[6*8+3].addPiece(new Piece(PieceType.Queen, PieceColor.White));
        spaces[6*8+4].addPiece(new Piece(PieceType.King, PieceColor.White));
        spaces[6*8+5].addPiece(new Piece(PieceType.Bishop, PieceColor.White));
        spaces[6*8+6].addPiece(new Piece(PieceType.Knight, PieceColor.White));
        spaces[6*8+7].addPiece(new Piece(PieceType.Rook, PieceColor.White));  
    }
}
