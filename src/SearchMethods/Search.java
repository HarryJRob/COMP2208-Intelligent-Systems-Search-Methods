package SearchMethods;
import Game.BlocksWorld;

public abstract class Search {

    public abstract String solveBlocksWorld(BlocksWorld b);

    protected static boolean playGame(BlocksWorld b, String moves) {
        b.resetBoard();
        for(char c : moves.toCharArray()) {
            switch (c) {
                case 'w':
                    b.moveUp();
                    break;
                case 'd':
                    b.moveRight();
                    break;
                case 's':
                    b.moveDown();
                    break;
                case 'a':
                    b.moveLeft();
                    break;
            }
        }
        
        return b.isComplete();
    }

}