package SearchMethods;
import Game.BlocksWorld;

import java.util.Collections;
import java.util.Stack;
import java.util.List;

public class DepthSearch extends Search {

    @Override
    public String solveBlocksWorld(BlocksWorld b) {
        Stack<String> toExpand = new Stack<String>();
        toExpand.add("");

        while(toExpand.size() != 0) {
            String curNode = toExpand.pop();
            if(playGame(b, curNode)) {
                return curNode;
            } else {
                List<String> nodes = getPossibleMoves(b,curNode);
                Collections.shuffle(nodes);
                toExpand.addAll(nodes);
            }
        }
        return null;
    }

}