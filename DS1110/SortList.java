package DS1110;

/**
 * A linked implementation of the ADT list.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class SortList<T extends Comparable<? super T>> implements SortedListInterface<T> {
	private Node<T> firstNode; // reference to first node
	private int numberOfEntries;

	public SortList() {
		clear();
	} // end default constructor

	public final void clear() // note the final method
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end clear

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return true if the bag is empty, or false if not
	 */
	public boolean isEmpty() {
		return this.numberOfEntries == 0;
	}

	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		Node nodeBefore = getNodeBefore(newEntry); //삽입하려는 값보다 작은 노드를 찾아줌
		//정렬하면서 삽입하기 때문에 이 노드 뒤에 삽입하고 연결

		if (isEmpty() || (nodeBefore == null)) // add at beginning
		{
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		} else // add after nodeBefore
		{
			Node nodeAfter = nodeBefore.getNextNode();//원래 삽입 자리 앞의 노드의 다음 노드는 잠시 저장해뒀다가 삽입 노드 뒤에 삽입
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		} // end if
		numberOfEntries++;

	}

	public boolean add(int newPosition, T newEntry) throws Exception {
		throw new Exception("not allowed");
		// return false;
		/*
		 * Node preNode = null; Node targetNode = null; Node<T> newNode = new
		 * Node<T>(newEntry); if (newPosition > 1) { preNode = getNodeAt(newPosition-1);
		 * targetNode = preNode.getNextNode();
		 * 
		 * preNode.setNextNode(newNode); newNode.setNextNode(targetNode); } else {
		 * //newPosition == 1 preNode = null; targetNode = firstNode;
		 * newNode.setNextNode(targetNode); firstNode = newNode; } return true;
		 */
	}

	public T remove(int givenPosition) {
		T result = null;

		if (givenPosition < 1 || givenPosition > numberOfEntries) {
			return null;
		}

		if (givenPosition > 1) {
			Node<T> nodeBefore = getNodeAt(givenPosition - 1);
			Node<T> nodeToRemove = nodeBefore.getNextNode();
			Node<T> nodeAfter = nodeToRemove.getNextNode();
			nodeBefore.setNextNode(nodeAfter);
			result = nodeToRemove.getData();
		} else {
			// givenPosition == 1
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
		}
		numberOfEntries--;
		return result;
	}

	public T getEntry(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			result = getNodeAt(givenPosition).getData();
		}
		return result;
	}

	public int getLength() {
		return numberOfEntries;
	}

	/*
	 * < Implementations of the public methods add, remove, replace, getEntry,
	 * contains, getLength, isEmpty, and toArray go here. > . . .
	 */

	// Returns a reference to the node at a given position.
	// Precondition: List is not empty;
	// 1 <= givenPosition <= numberOfEntries
	private Node<T> getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		// traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;

		return currentNode;
	} // end getNodeAt

	public T[] toArray() {
		// to do
		return null;
	}

	public boolean contains(T anEntry) {
		return getPosition(anEntry) > 0 ? true : false;
	} // end contains

	public int getPosition(T anEntry) {
		int position = 1;
		int length = numberOfEntries;

		Node<T> currentNode = firstNode;

		// find position of anEntry
		while ((position <= length) && (anEntry.compareTo(currentNode.getData()) > 0)) {
			position++;
			currentNode = currentNode.getNextNode();
		} // end while

		// see whether anEntry is in list
		if ((position > length) || (anEntry.compareTo(currentNode.getData()) != 0)) {
			position = -position; // anEntry is not in list
		} // end if

		return position;
	}

	public boolean remove(T anEntry) {
		int targetPosition = this.getPosition(anEntry);
		if (targetPosition < 1 || targetPosition > this.numberOfEntries) {
			return false;
		} else {
			this.remove(targetPosition);
			return true;
		}
	}

	/**
	 * Finds the node that is before the node that should or does contain a given
	 * entry.
	 * 
	 * @param anEntry the object to be located
	 * @return either a reference to the node that is before the node that contains
	 *         or should contain anEntry, or null if no prior node exists (that is,
	 *         if anEntry belongs at the beginning of the list)
	 */
	private Node getNodeBefore(T anEntry) {
		Node<T> currentNode = firstNode;
		Node<T> nodeBefore = null;

		while ((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0)) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		} // end while

		return nodeBefore;
	} // end getNodeBefore

} // end LList