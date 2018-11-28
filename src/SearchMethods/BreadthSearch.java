package SearchMethods;
import Game.BlocksWorld;
import java.util.Queue;
import java.util.LinkedList;

public final class BreadthSearch extends Search {

    @Override
    public String solveBlocksWorld(BlocksWorld b) {
        Queue<String> toExpand = new LinkedList<String>();
        toExpand.add("");

        while(toExpand.size() != 0) {
            if(toExpand.size() > mostNodesStored) {
                mostNodesStored = toExpand.size();
            }

            String curNode = toExpand.remove();
            //System.out.println("Expanding: " + curNode);
            if(playGame(b, curNode)) {
                return curNode;
            } else {
                toExpand.addAll(getPossibleMoves(b,curNode));
            }
        }
        return null;
    }

}