package Ds1111;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
 
public class IteratorTest {     
    private static ArrayList<Integer> mArrayList;
 
    public static void main(String[] args) {         
         
        // ArrayList 생성
        mArrayList = new ArrayList<Integer>();
         
        // ArrayList 값 추가
        mArrayList.add(10);
        mArrayList.add(20);
        mArrayList.add(30);
        mArrayList.add(40);
        mArrayList.add(50);
        System.out.println();
        Iterator iter = mArrayList.iterator();
        while( iter.hasNext() ) {
            System.out.println(" "  + iter.next() );
        }

        Vector<String> vec = new Vector<String>();
        vec.add("hello");
        vec.add("great");
        vec.add("nice");
        Iterator iter2 = vec.iterator();
        while( iter2.hasNext() ) {
	System.out.println( iter2.next() );
        }
        //
        System.out.println( "-------------");
        for (String st : vec) {
	System.out.println( st);
        }

    } 
}