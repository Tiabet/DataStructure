package DS1115;

import java.util.*;

public class TestHashMap3 {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(21, "Twenty One");
//map.put(21.0, "Twenty One"); //this will throw compiler error because 21.0 is not integer

//Retrieving value from HashMap
        Integer key = 21;
        String value = map.get(key);
        System.out.println("Key: " + key + " value: " + value);
//Output: Key: 21 value: Twenty One

//Iterating over HashMap
        map.put(21, "Twenty One");
        map.put(31, "Thirty One");
        System.out.println("Key: " + 31 + " value: " + map.get(31)); //같은 키에 값이 두개 들어오면 원래 있던건 덮어씌워짐
        map.put(44, "Forty Four");
        Iterator<Integer> keySetIterator = map.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Integer tempkey = keySetIterator.next();
            System.out.println("[map] key: " + tempkey + " value: " + map.get(tempkey));
        }
        HashSet<Integer> set1 = new HashSet<Integer>(map.keySet());
        //HashMap<Integer,String> temp = new HashMap();
        //temp.putAll(map);
        //Set<Integer> set1 = temp.keySet(); //a copy

        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(21, "21");
        map2.put(30, "30");

        Set<Integer> set2 = map2.keySet();
        set1.retainAll(set2);//retainAll을 써주면 겹치는것만 남음
        Iterator<Integer> iter1 = set1.iterator();
        while (iter1.hasNext()) {
            System.out.println("intersection:" + iter1.next());
        }

        HashSet<Integer> set12 = new HashSet<Integer>(map.keySet());
        Set<Integer> set3 = map2.keySet();
        set12.addAll(set3); //union
        Iterator<Integer> iter22 = set12.iterator();
        while (iter22.hasNext()) {
            System.out.println("union:" + iter22.next());
        }

    }
}
