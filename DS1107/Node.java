package DS1107;

public class Node<T> {

    protected T data; // entry in bag
    protected Node next; // link to next node

    public Node(T dataPortion) {
        this(dataPortion, null);
    } // end constructor

    public Node(T dataPortion, Node nextNode) {
        data = dataPortion;
        next = nextNode;
    } // end constructor

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node nn) {
        next = nn;
    }

    public T getData() {
        return data;
    }
} // end Node
