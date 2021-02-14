import javax.swing.*;
import java.awt.*;

public class TetrisBoard extends JFrame implements Runnable {
    /* 게임 창 사이즈 */
    final static int BOARD_WIDTH = 600;
    final static int BOARD_HEIGHT = 700;

    /* 게임 보더 사이즈 */
    final static int GAME_BOARD_WIDTH = 360;
    final static int GAME_BOARD_HEIGTH = 600;

    /* 미리보기 사이즈 */
    final static int PREVIEW_SIZE = 150;

    /* 게임 보더 실제 사이즈 */
    final static int GAME_BOARD_CELL_WIDTH = 12;
    final static int GAME_BOARD_CELL_HEIGHT = 20;

    /* 블럭 사이즈 */
    final static int BLOCK_SIZE = 30;

    /* 점수 */
    private int score = 0;

    /* 게임 보더 배열 */
    private boolean[][] gameBoard = new boolean[GAME_BOARD_HEIGTH][GAME_BOARD_CELL_WIDTH];

    /* 현재 블럭 위치 */
    private int curX;
    private int curY;

    private int width = GAME_BOARD_CELL_WIDTH/2;
    private int height = 0;

    /* 블럭 */
    Block block = new Block();

    public TetrisBoard() {
        setTitle("Tetris Game");
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBackground(Color.WHITE);
        setForeground(Color.WHITE);

        /* 게임 보드 초기화 */
        for(int i = 0; i < GAME_BOARD_CELL_HEIGHT; i++) {
            gameBoard[i][0] = true;
            gameBoard[i][GAME_BOARD_CELL_WIDTH-1] = true;
        }
        for(int i = 0; i < GAME_BOARD_CELL_WIDTH; i++) {
            gameBoard[GAME_BOARD_CELL_HEIGHT-1][i] = true;
        }
    }

    public void paint(Graphics g) {
        nextDown(g);
        makeBoard(g);
        makeBlock(g);
        blockDown(g);
    }

    public void makeBoard(Graphics g) {
        g.drawRect(10, 50, GAME_BOARD_WIDTH, GAME_BOARD_HEIGTH);
        g.drawRect(10+GAME_BOARD_WIDTH+20,50, PREVIEW_SIZE, PREVIEW_SIZE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score : " + score, 10+GAME_BOARD_WIDTH+20,  50 + PREVIEW_SIZE + 50);
    }

    /* 블럭 생성 */
    public void makeBlock(Graphics g) {
        g.setColor(Color.GRAY);
        for(int i = 0; i < GAME_BOARD_CELL_HEIGHT; i++) {
            for(int j = 0; j < GAME_BOARD_CELL_WIDTH; j++) {
                if(gameBoard[i][j] == true) {
                    g.fill3DRect(j*BLOCK_SIZE+10, i*BLOCK_SIZE+50, BLOCK_SIZE, BLOCK_SIZE, true);
                }
            }
        }
    }

    public void blockDown(Graphics g) {
        g.setColor(Color.RED);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(block.block[i][j] == true) {
                    curX = (width+j)*BLOCK_SIZE;
                    curY = (height+i)*BLOCK_SIZE;
                    g.fill3DRect(curX+10, curY+50, BLOCK_SIZE, BLOCK_SIZE, true);
                }
            }
        }
    }

    public void nextDown(Graphics g) {
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (block.block[i][j] == true) {
                    curX = (width + j) * BLOCK_SIZE;
                    curY = (height + i) * BLOCK_SIZE;
                    g.clearRect(curX + 10, curY + 50, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
        height++;
    }
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                repaint();
            }
            catch (InterruptedException e) {
                return;
            }
        }
    }
}
