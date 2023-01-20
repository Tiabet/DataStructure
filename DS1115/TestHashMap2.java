package DS1115;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
public class TestHashMap2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(10, "Number 10");
        map.put(5, "My number five");
        map.put(1, "number one");
        map.put(11, "eleVen!");
        
        String myvalue = map.get(6);
        System.out.println("myvalue:" + myvalue);
        System.out.println("20 exists? " + map.containsKey(20));
        
        Iterator<Integer> myiter = map.keySet().iterator();
        while(myiter.hasNext() ) {
            int myTempKey = myiter.next();
            System.out.println("myTempKey:" + myTempKey + ":" + map.get(myTempKey));
        }        
        
        Set myset = map.entrySet();
        //entrySet은 key와 value가 set으로 같이 들어있음
        Iterator<Entry> myiter2 = myset.iterator();
        while( myiter2.hasNext() )
        {
            Entry<Integer,String> entry = myiter2.next();
            System.out.println("Key:" +entry.getKey() +": value " + entry.getValue() );
        }
    }    
}
