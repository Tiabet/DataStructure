package DS0920;

public class MyNode<T>
{
    private T data; // entry in bag
    private MyNode next; // link to next node
    public MyNode (T dataPortion)
    {
        this(dataPortion, null);
    } // end constructor

    public MyNode (T dataPortion,MyNode nextNode)
    {
        data = dataPortion;
        next = nextNode;
    } // end constructor
    
    public MyNode getNextNode() {
    	return next;
    }
    
    public T getData() {
    	return data;
    }
} // end Node