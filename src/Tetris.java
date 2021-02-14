public class Tetris {
    public static void main(String[] args) {
        Thread th = new Thread(new TetrisBoard());
        th.start();
    }
}
