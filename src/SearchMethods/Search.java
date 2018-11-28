package SearchMethods;
import Game.BlocksWorld;
import java.util.List;
import java.util.LinkedList;

public abstract class Search {

    private int numberOfNodesTested = 0; 
    protected int mostNodesStored = 0;

    public abstract String solveBlocksWorld(BlocksWorld b);

    protected boolean playGame(BlocksWorld b, String moves) {
        numberOfNodesTested++;

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

    protected static List<String> getPossibleMoves(BlocksWorld b, String curMoves) {
        char[][] board = b.getBoard();
        int agentX = b.getAgentX();
        int agentY = b.getAgentY();
        List<String> returnList = new LinkedList<String>();

        //Up
        if(b.canMoveUp()) {
            returnList.add(curMoves + "w");
        }
        
        //Left
        if(b.canMoveLeft()) {
            returnList.add(curMoves + "a");
        }

        //Down
        if(b.canMoveDown()) {
            returnList.add(curMoves + "s");
        }

        //Right
        if(b.canMoveRight()) {
            returnList.add(curMoves + "d");
        }
        
        return returnList;
    }

    public int getNumNodesTested() {
        return numberOfNodesTested;
    }

    public int getMaxNumNodesStored() {
        return mostNodesStored;
    }
}