public class Game {
    Block block;
    public void gameStart() {
        new TetrisBoard();

        while(true) {
            block = new Block();
        }
    }
}
