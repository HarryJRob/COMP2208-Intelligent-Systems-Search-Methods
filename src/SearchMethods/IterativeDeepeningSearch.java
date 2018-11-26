package SearchMethods;

import Game.BlocksWorld;
import java.util.Stack;
import java.util.List;
import java.util.Collections;

public class IterativeDeepeningSearch extends Search {

    @Override
    public String solveBlocksWorld(BlocksWorld b) {
        int curLevel = 0;

        while(true) {
            String result = DFLS(b, curLevel);

            if(result != null) {
                return result;

            } else {
                curLevel++;
            }
        }
    }

    public String DFLS(BlocksWorld b, int n) {
        Stack<String> toExpand = new Stack<String>();
        toExpand.add("");

        while(toExpand.size() != 0) {
            String curNode = toExpand.pop();

            if(playGame(b, curNode)) {
                return curNode;

            } else {
                if(curNode.length() < n) {
                    List<String> nodes = getPossibleMoves(b,curNode);
                    Collections.shuffle(nodes);
                    toExpand.addAll(nodes);
                }
            }
        }
        return null;
    }

}