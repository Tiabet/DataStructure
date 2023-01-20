package Ds1111;

import java.util.Iterator;

public class TestDriver1 {

    public static void main(String[] args) {
        ListInterface<String> nameList = new LList<String>();
        nameList.add("Jamie");
        nameList.add("Joey");
        nameList.add("Rachel");

        Iterator<String> nameIterator = new SeparateIterator<String>(nameList);
        System.out.println("" + nameIterator.hasNext());
        // returns true because a next entry exists.
        System.out.println("" + nameIterator.next());
        // returns the string Jamie and advances the iterator.
        System.out.println("" + nameIterator.next());
        // returns the string Joey and advances the iterator.
        System.out.println("" + nameIterator.next());
        // returns the string Rachel and advances the iterator.
        System.out.println("" + nameIterator.hasNext());
        // returns false because the iterator is beyond the end of the list.
        System.out.println("" + nameIterator.next());
        // causes a NoSuchElementException.
    }
}
