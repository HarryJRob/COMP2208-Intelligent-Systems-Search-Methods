package Game;

public class Block {

    private int x;
    private int y;
    private char val;

    public Block(int x, int y, char val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getVal() {
        return val;
    }
}