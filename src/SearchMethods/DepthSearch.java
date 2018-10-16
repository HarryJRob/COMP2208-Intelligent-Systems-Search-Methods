package SearchMethods;
import Game.BlocksWorld;

import java.util.Collections;
import java.util.Stack;
import java.util.LinkedList;

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
                LinkedList<String> successors = new LinkedList<String>();
                successors.add(curNode+"w");
                successors.add(curNode+"s");
                successors.add(curNode+"a");
                successors.add(curNode+"d");
                Collections.shuffle(successors);
                toExpand.addAll(successors);
            }
        }
        return null;
    }

}