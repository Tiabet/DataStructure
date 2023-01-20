package DS1107;public class LinkedGroup<T extends Comparable<? super T>> {    private Node firstNode;    int numberOfEntries; // number of objects in the group    /*/     * insertinorder메소드를 이용해서 앞에게 자신보다 작으면 그 자리에 삽입하는 과정이 InsertionSort     */    public boolean add(T newEntry) {        Node<T> newNode = new Node<T>(newEntry);        //Node<T> newNode = new Node(newEntry);        newNode.next = firstNode;        firstNode = newNode;        numberOfEntries++;        return true; //먼저 add된 게 더 앞에 있는 메소드    }    public void insertionSort() {        // if zero or one item is in the list, there is nothing to do        if (numberOfEntries > 1) {            assert firstNode != null;            // break chain into 2 pieces: sorted and unsorted            Node unsortedPart = firstNode.getNextNode();            assert unsortedPart != null;            firstNode.setNextNode(null);            while (unsortedPart != null) {                Node nodeToInsert = unsortedPart;                unsortedPart = unsortedPart.getNextNode();                //System.out.println("Before 1");                //printAll();                insertInOrder(nodeToInsert);                //System.out.println("After 1");                //printAll();            } // end while        } // end if    } // end insertionSort    public void printAll() {        int index = 0;        Node<T> currentNode = firstNode;        while ((index < this.numberOfEntries) && (currentNode != null)) {            System.out.println("" + index + ":" + currentNode.data);            index++;            currentNode = currentNode.next;        }    }    private void insertInOrder(Node<T> nodeToInsert) {        T item = nodeToInsert.getData();        Node<T> currentNode = firstNode;        Node<T> previousNode = null;        // locate insertion point        while ((currentNode != null)                && ( item.compareTo(currentNode.data) > 0                 )) {            previousNode = currentNode;            currentNode = currentNode.getNextNode();         } // end while, 삽입할 노드보다 작은 노드를 찾고 그 노드와 그 뒤의 노드를 저장함        // make the insertion        if ( previousNode == null ) {            nodeToInsert.setNextNode(firstNode);            firstNode = nodeToInsert;        } else {            previousNode.setNextNode(nodeToInsert);            nodeToInsert.setNextNode(currentNode); //저장한 두 노드 사이에 노드를 삽입        }    } // end insertInOrder} // end LinkedChainList