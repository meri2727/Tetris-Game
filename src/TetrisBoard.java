import javax.swing.*;

public class TetrisBoard extends JFrame {
    final static int BOARD_WIDTH = 600;
    final static int BOARD_HEIGHT = 700;

    public TetrisBoard() {
        setTitle("Tetris Game");
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
