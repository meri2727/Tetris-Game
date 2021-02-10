import javax.swing.*;
import java.awt.*;

public class TetrisBoard extends JFrame {
    final static int BOARD_WIDTH = 600;
    final static int BOARD_HEIGHT = 700;

    final static int GAME_BOARD_WIDTH = 400;
    final static int GAME_BOARD_HEIGTH = 600;

    final static int PREVIEW_SIZE = 150;

    final static int GAME_BOARD_CELL_WIDHT = 10;
    final static int GAME_BOARD_CELL_HEIGHT = 15;

    private int score = 0;

    private boolean[][] gameBoard = new boolean[GAME_BOARD_HEIGTH][GAME_BOARD_CELL_WIDHT];

    public TetrisBoard() {
        setTitle("Tetris Game");
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        for(int i = 0; i < GAME_BOARD_CELL_HEIGHT; i++) {
            gameBoard[i][0] = true;
            gameBoard[i][GAME_BOARD_CELL_WIDHT-1] = true;
        }
        for(int i = 0; i < GAME_BOARD_CELL_WIDHT; i++) {
            gameBoard[GAME_BOARD_CELL_HEIGHT-1][i] = true;
        }

        for(int i = 0; i < GAME_BOARD_CELL_HEIGHT; i++) {
            for(int j = 0; j < GAME_BOARD_CELL_WIDHT; j++) {
                if(gameBoard[i][j] == true) {
                    System.out.print("*");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public void paint(Graphics g) {
        g.drawRect(10, 50, GAME_BOARD_WIDTH, GAME_BOARD_HEIGTH); //Game Board
        g.drawRect(10+GAME_BOARD_WIDTH+20,50, PREVIEW_SIZE, PREVIEW_SIZE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score : " + score, 10+GAME_BOARD_WIDTH+20,  50 + PREVIEW_SIZE + 50);
    }
}
