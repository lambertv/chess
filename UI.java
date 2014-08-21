import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class UI extends JPanel implements MouseListener {
    private static Game chess_game = new Game();
    private static ImagePanel board_panel = new ImagePanel(chess_game.getBoard());

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JComponent newContentPane = new UI();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        board_panel.setPreferredSize(new Dimension(320,320));
        frame.add(board_panel);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public UI() {
        board_panel.setPreferredSize(new Dimension(320,320));
        board_panel.addMouseListener(this);
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        int x = (e.getX()-32)/32;
        int y = (e.getY()-32)/32;
        if (inClickableArea(e.getX(), e.getY()) && 
            !chess_game.pieceSelected() && chess_game.isPieceAt(x, y)) {
            System.out.println("SELECTING PIECE");
            chess_game.setSelectedPiece(x,y);
        } else if (inClickableArea(e.getX(),e.getY()) && chess_game.pieceSelected()) {
            System.out.println("SELECT MOVE?");
            chess_game.setSelectedMove(x, y);
            if (chess_game.getSelectedMove() != null) {
                System.out.println("SELECTING MOVE");
                chess_game.makeSelectedMove();
            } else {
                System.out.println("MOVE DOESN'T EXIST");
                chess_game.deselectPiece();
            }
        } else {
            System.out.println("NOT IN CLICKABLE AREA OR IS NOT VALID SELECTION");
            chess_game.deselectPiece();
        }
        board_panel.update(chess_game.getBoard(), chess_game.getPossibleMoves());
        board_panel.repaint();
    }

    public void mouseEntered(MouseEvent e) {
        return;
    }

    public void mouseExited(MouseEvent e) {
        return;
    }

    public void mousePressed(MouseEvent e) {
        return;
    }

    public void mouseReleased(MouseEvent e) {
        return;
    }
    public boolean inClickableArea(int x, int y) {
        return (x > 32 && x < 320-32 && y > 32 && y < 320-32);
    }
}
