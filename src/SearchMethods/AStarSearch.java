package SearchMethods;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.List;

import Game.*;

public class AStarSearch extends Search {

    @Override
    public String solveBlocksWorld(BlocksWorld b) {
        PriorityQueue<Node> toExpand = new PriorityQueue<Node>(new NodeComparator());

        toExpand.add(new Node("", 0));

        while(toExpand.size() != 0) {
            Node curNode = toExpand.poll();

            System.out.println("Expanding: \n" + curNode.value + "\n" + curNode.priority);

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

    private float applyHeuristic(BlocksWorld b, String moves) {
        int distanceFromStart = moves.length() - 1;
        float aproxDistanceToEnd = calcAproxDistanceToEnd(b, moves);

        return distanceFromStart + aproxDistanceToEnd;


    }

    private float calcAproxDistanceToEnd(BlocksWorld b, String moves) {
            playGame(b, moves);
            char[][] currentBoard = b.getBoard();

            List<Block> currentBlockLocations = new LinkedList<Block>();

            for(int y = 0; y < currentBoard.length; y++) {
                for(int x = 0; x < currentBoard[y].length; x++) {
                    if(currentBoard[y][x] != ' ' && currentBoard[y][x] != b.AGENT_REPRESENTATION) {
                        currentBlockLocations.add(new Block(x,y,currentBoard[y][x]));
                    }
                }
            }

            List<Block> finaBlockLocations = b.getSolution();
            int returnValue = 0;

            for(Block endBlock : finaBlockLocations) {
                for(Block startBlock : currentBlockLocations) {
                    if(endBlock.getVal() == startBlock.getVal()) {
                        returnValue += (float) Math.sqrt((endBlock.getX() - startBlock.getX())^2 + (endBlock.getY() - startBlock.getY())^2);
                        break;
                    }
                }
            }

            return returnValue;
    }

    private class Node {
        private String value;
        private float priority;

        public Node(String value, float priority) {
            this.value = value;
            this.priority = priority;
        }

        public String getValue() {
            return value;
        }

        public float getPriority() {
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