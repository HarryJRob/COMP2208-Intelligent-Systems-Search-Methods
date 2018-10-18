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
                return curNode.getValue();
            } else {
                toExpand.add(new Node(curNode.getValue() + "w", applyHeuristic(b,curNode.getValue() + "w")));
                toExpand.add(new Node(curNode.getValue() + "a", applyHeuristic(b,curNode.getValue() + "a")));
                toExpand.add(new Node(curNode.getValue() + "s", applyHeuristic(b,curNode.getValue() + "s")));
                toExpand.add(new Node(curNode.getValue() + "d", applyHeuristic(b,curNode.getValue() + "d")));
            }
        }

        return null;
    }

    private int applyHeuristic(BlocksWorld b, String moves) {
        int distanceFromStart = moves.length() - 1;
        int aproxDistanceToEnd = 0;

        return distanceFromStart + aproxDistanceToEnd;
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