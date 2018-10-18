package SearchMethods;

import java.util.Comparator;
import java.util.PriorityQueue;

import Game.BlocksWorld;

public class AStarSearch extends Search {

    @Override
    public String solveBlocksWorld(BlocksWorld b) {
        PriorityQueue<Node> toExpand = new PriorityQueue<Node>(new NodeComparator());

        toExpand.add(new Node("", 0));

        while(toExpand.size() != 0) {
           Node curNode = toExpand.poll();

           if(playGame(b, curNode.getValue())) {

           } else {
               
           }
        }

        return null;
    }

    private int applyHeuristic() {
        return -1;
    }

    private class Node {
        private String value;
        private int priority;

        public Node(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public String getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }
    }

    private class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node x, Node y) {
            if(x.getPriority() < y.getPriority()) {
                return -1;
            } 
            if(x.getPriority() > y.getPriority()) {
                return 1;
            }
            return 0;
        }
    }

}