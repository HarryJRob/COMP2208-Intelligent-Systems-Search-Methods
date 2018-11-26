package SearchMethods;
import Game.BlocksWorld;
import java.util.List;
import java.util.LinkedList;

public abstract class Search {

    private int numberOfNodesExpanded = 0; 

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

    protected List<String> getPossibleMoves(BlocksWorld b, String curMoves) {
        numberOfNodesExpanded++;

        char[][] board = b.getBoard();
        int agentX = b.getAgentX();
        int agentY = b.getAgentY();
        List<String> returnList = new LinkedList<String>();

        //Up
        if(agentY != 0) {
            returnList.add(curMoves + "w");
        }
        
        //Left
        if(agentX != 0) {
            returnList.add(curMoves + "a");
        }

        //Down
        if(agentY != board.length-1) {
            returnList.add(curMoves + "s");
        }

        //Right
        if(agentX != board.length-1) {
            returnList.add(curMoves + "d");
        }
        
        return returnList;
    }

    public int getNumNodesExpanded() {
        return numberOfNodesExpanded;
    }

}