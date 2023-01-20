package DS1012;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {
        Deque deque = new LinkedList<>();
        
        // We can add elements to the queue in various ways
        deque.add("Element 1 (Tail)"); // add to tail
		deque.add("Element 2 (Tail)"); // add to tail
        deque.addFirst("Element 3 (Head)");
        deque.addLast("Element 4 (Tail)");
        //deque.push("Element 4 (Head)"); //add to head
        //deque.offer("Element 5 (Tail)");
        //deque.offerFirst("Element 6 (Head)");
        //deque.offerLast("Element 7 (Tail)");
        
        System.out.println(deque + "\n");

        // Peek returns the head, without deleting it from the deque
        System.out.println("Peek " + deque.peek());
		System.out.println("PeekFirst" + deque.peekFirst());
		System.out.println("PeekLast" + deque.peekLast());
        System.out.println("After peek: " + deque);

        // We can remove the first / last element.
        deque.removeFirst();
        //deque.removeLast();
        System.out.println("Deque after removing first and last: " + deque);   

        // Iterate through the queue elements.
        //System.out.println("Standard Iterator");
        //Iterator iterator = deque.iterator();
        //while (iterator.hasNext()) {
        //    System.out.println("\t" + iterator.next());
        //}
        
        // Reverse order iterator
		/*
        Iterator reverse = deque.descendingIterator();
        System.out.println("Reverse Iterator");
        while (reverse.hasNext()) {
            System.out.println("\t" + reverse.next());
        }
        
        // Peek returns the head, without deleting it from the deque
        System.out.println("Peek " + deque.peek());
        System.out.println("After peek: " + deque);
        
        // Pop returns the head, and removes it from the deque
        System.out.println("Pop " + deque.pop());
        System.out.println("After pop: " + deque);
        
        // We can check if a specific element exists in the deque
        System.out.println("Contains element 3: " + deque.contains("Element 3 (Tail)"));
        */
    }
}