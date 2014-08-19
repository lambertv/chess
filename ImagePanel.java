import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.Map;
import java.util.LinkedList;

public class ImagePanel extends JPanel {

    private Board game_board;

    private BufferedImage board_image;

    private BufferedImage black_king_image;
    private BufferedImage black_queen_image;
    private BufferedImage black_pawn_image;
    private BufferedImage black_rook_image;
    private BufferedImage black_knight_image;
    private BufferedImage black_bishop_image;

    private BufferedImage white_king_image;
    private BufferedImage white_queen_image;
    private BufferedImage white_pawn_image;
    private BufferedImage white_rook_image;
    private BufferedImage white_knight_image;
    private BufferedImage white_bishop_image;

    public ImagePanel(Board game_board) {
        try {
            board_image = ImageIO.read(new File("chess_board.png"));

            black_king_image = ImageIO.read(new File("black_king.png"));
            black_queen_image = ImageIO.read(new File("black_queen.png"));
            black_pawn_image = ImageIO.read(new File("black_pawn.png"));
            black_rook_image = ImageIO.read(new File("black_rook.png"));
            black_knight_image = ImageIO.read(new File("black_knight.png"));
            black_bishop_image = ImageIO.read(new File("black_bishop.png"));

            white_king_image = ImageIO.read(new File("white_king.png"));
            white_queen_image = ImageIO.read(new File("white_queen.png"));
            white_pawn_image = ImageIO.read(new File("white_pawn.png"));
            white_rook_image = ImageIO.read(new File("white_rook.png"));
            white_knight_image = ImageIO.read(new File("white_knight.png"));
            white_bishop_image = ImageIO.read(new File("white_bishop.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }

        this.game_board = game_board;
    }

    public void update(Board game_board) {
        this.game_board = game_board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(board_image, 0, 0, null);

        for (Square square : game_board.getSquares()) {
            if (square.piece.color == PieceColor.Black) {
                if (square.piece.type == PieceType.King) {
                    g.drawImage(black_king_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Queen) {
                    g.drawImage(black_queen_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Pawn) {
                    g.drawImage(black_pawn_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Rook) {
                    g.drawImage(black_rook_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Knight) {
                    g.drawImage(black_knight_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else {               
                    g.drawImage(black_bishop_image, 32+square.x*32, 
                                32+square.y*32, null);
                }
            } else {
                if (square.piece.type == PieceType.King) {
                    g.drawImage(white_king_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Queen) {
                    g.drawImage(white_queen_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Pawn) {
                    g.drawImage(white_pawn_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Rook) {
                    g.drawImage(white_rook_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else if (square.piece.type == PieceType.Knight) {
                    g.drawImage(white_knight_image, 32+square.x*32, 
                                32+square.y*32, null);
                } else {               
                    g.drawImage(white_bishop_image, 32+square.x*32, 
                                32+square.y*32, null);
                }
            }
        }
    }
}
