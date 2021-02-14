public class Block {
    public boolean[][] block = new boolean[4][4];
    int blockType = (int) Math.floor(Math.random() * 7);

    public Block() {
        switch (blockType) {
            case 0: //I
                /*
                * . . .
                * . . .
                * . . .
                * . . .
                 */
                block[0][0] = true;
                block[1][0] = true;
                block[2][0] = true;
                block[3][0] = true;
                break;
            case 1: //L
                /*
                * . . .
                * . . .
                * * . .
                . . . .
                 */
                block[0][0] = true;
                block[1][0] = true;
                block[2][0] = true;
                block[2][1] = true;
                break;
            case 2: //J
                /*
                . * . .
                . * . .
                * * . .
                . . . .
                 */
                block[0][1] = true;
                block[1][1] = true;
                block[2][0] = true;
                block[2][1] = true;
                break;
            case 3: //O
                /*
                * * . .
                * * . .
                . . . .
                . . . .
                 */
                block[0][0] = true;
                block[0][1] = true;
                block[1][0] = true;
                block[1][1] = true;
                break;
            case 4: //S
                /*
                . * * .
                * * . .
                . . . .
                . . . .
                 */
                block[0][1] = true;
                block[0][2] = true;
                block[1][0] = true;
                block[1][1] = true;
                break;
            case 5: //T
                /*
                * * * .
                . * . .
                . . . .
                . . . .
                 */
                block[0][0] = true;
                block[0][1] = true;
                block[0][2] = true;
                block[1][1] = true;
                break;
            case 6: //Z
                /*
                * * . .
                . * * .
                . . . .
                . . . .
                 */
                block[0][0] = true;
                block[0][1] = true;
                block[1][1] = true;
                block[1][2] = true;
                break;
        }

    }
    public void RightRotation() {

    }

    public void leftRotation() {

    }
}
