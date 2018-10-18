package SearchMethods;

import Game.BlocksWorld;
import java.util.Stack;
import java.util.LinkedList;
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
                    LinkedList<String> successors = new LinkedList<String>();
                    successors.add(curNode+"w");
                    successors.add(curNode+"s");
                    successors.add(curNode+"a");
                    successors.add(curNode+"d");
                    Collections.shuffle(successors);
                    toExpand.addAll(successors);
               }
            }
        }
        return null;
    }

}