package SearchMethods;
import Game.BlocksWorld;

public abstract class Search {

    public abstract String SolveBlocksWorld(BlocksWorld b);

    protected static boolean playGame(BlocksWorld b, String moves) {
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
        boolean isComplete = b.isComplete();
        b.resetBoard();
        return isComplete;
    }

}