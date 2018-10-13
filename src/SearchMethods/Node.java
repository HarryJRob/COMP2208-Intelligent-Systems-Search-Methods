package SearchMethods;
import java.util.List;
import java.util.ArrayList;

public class Node<T> {

    private T value;
    private List<Node<T>> children;

    public Node(T value) {
        this.value = value;
        children = new ArrayList<Node<T>>();
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

    public void addChildren(List<Node<T>> children) {
        for(Node<T> child : children) {
            this.children.add(child);
        }
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getValue() {
        return value;
    }

}