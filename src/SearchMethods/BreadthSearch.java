package SearchMethods;
import Game.BlocksWorld;
import java.util.Queue;
import java.util.LinkedList;

public final class BreadthSearch extends Search {

    @Override
    public String SolveBlocksWorld(BlocksWorld b) {
        Queue<Node<String>> toExpand = new LinkedList<Node<String>>();
        toExpand.add(new Node<String>(""));

        while(toExpand.size() != 0) {
            Node<String> curNode = toExpand.remove();
            if(playGame(b, curNode.getValue())) {
                return curNode.getValue();
            } else {
                expandNode(curNode);
                for(Node<String> n : curNode.getChildren()) {
                    toExpand.add(n);
                }
            }
        }
        return null;
    }

    private void expandNode(Node<String> n) {
        String s = n.getValue();
        n.addChild(new Node<String>(s+"w"));
        n.addChild(new Node<String>(s+"s"));
        n.addChild(new Node<String>(s+"a"));
        n.addChild(new Node<String>(s+"d"));
    }

}