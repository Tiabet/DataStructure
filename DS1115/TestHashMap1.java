package DS1115;

import java.util.*;
import java.util.Map.Entry;

public class TestHashMap1 {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(21, "Twenty One");
//map.put(21.0, "Twenty One"); //this will throw compiler error because 21.0 is not integer

//Retrieving value from HashMap
        Integer key = 21;
        String value = map.get(key);
        System.out.println("[0] Key: " + key + " value: " + value);
//Output: Key: 21 value: Twenty One

//Iterating over HashMap
        map.put(21, "Twenty One again");
        map.put(31, "Thirty One");
        Iterator<Integer> keySetIterator = map.keySet().iterator();
        Iterator<Entry<Integer, String>> entryIter = map.entrySet().iterator();
        while (keySetIterator.hasNext()) {
            Integer tempkey = keySetIterator.next();
            System.out.println("[1] key: " + tempkey + " value: " + map.get(tempkey));
        }
        while(entryIter.hasNext()) {
        	Entry<Integer, String> str = entryIter.next();
        	System.out.println(str);
        }
//Output: key: 21 value: Twenty One again;   key: 31 value: Thirty One

//ContainsKey and ContainsValue Example
        System.out.println("Does HashMap contains 21 as key: " + map.containsKey(21));
        System.out.println("Does HashMap contains 21 as value: " + map.containsValue(21));
        System.out.println("Does HashMap contains Twenty One again as value: " + map.containsValue("Twenty One again"));
//Output: Does HashMap contains 21 as key: true 
//Does HashMap contains 21 as value: false 
//Does HashMap contains Twenty One as value: true

//Checking if HashMap is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is HashMap is empty: " + isEmpty);
//Output: Is HashMap is empty: false

//Removing Objects from HashMap
        Integer tempkey2 = 21;
        Object tempvalue = map.remove(tempkey2);
        System.out.println("Following value is removed from Map: " + tempvalue);
//Output: Following value is removed from Map: Twenty One

//Soring HashMap
        map.put(21, "Twenty One");
        map.put(31, "Thirty One");
        map.put(41, "Thirty One");
        System.out.println("Unsorted HashMap: " + map);
        TreeMap sortedHashMap = new TreeMap(map);
        System.out.println("Sorted HashMap: " + sortedHashMap);
//Output: Unsorted HashMap: {21=Twenty One, 41=Thirty One, 31=Thirty One} 
//Sorted HashMap: {21=Twenty One, 31=Thirty One, 41=Thirty One}

    }
}
