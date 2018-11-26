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
        int distanceFromStart = moves.length();
        int aproxDistanceToEnd = calcAproxDistanceToEnd(b, moves);

        return distanceFromStart + aproxDistanceToEnd;
    }

    private int calcAproxDistanceToEnd(BlocksWorld b, String moves) {
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
                        int dist = (int) (Math.pow(endBlock.getX() - startBlock.getX(), 2) + Math.pow(endBlock.getY() - startBlock.getY(), 2));
                        returnValue += dist;
                        currentBlockLocations.remove(startBlock);
                        break;
                    }
                }
            }

            return returnValue;
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