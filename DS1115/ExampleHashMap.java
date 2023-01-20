package DS1115;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class ExampleHashMap {
		
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		System.out.println(map.hashCode());

		map.put(21, "Twenty"); 
		//map.put(21.0, "Twenty One"); //this will throw compiler error because 21.0 is not integer

		//Retrieving value from HashMap
		Integer key = 21; 
		String value = map.get(key); 
		System.out.println("Key: " + key +" value: "+ value); 
		//Output: Key: 21 value: Twenty One

		//Iterating over HashMap
		map.put(21, "Twenty One"); 
		map.put(31, "Thirty One"); 
		Iterator<Integer> keySetIterator = map.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			Integer tempkey = keySetIterator.next(); 
			System.out.println("key: " + tempkey + " value: " + map.get(tempkey)); 
		} 
		//Output: key: 21 value: Twenty One key: 31 value: Thirty One


		//ContainsKey and ContainsValue Example
		System.out.println("Does HashMap contains 21 as key: " + map.containsKey(21)); 
		System.out.println("Does HashMap contains 21 as value: " + map.containsValue(21)); 
		System.out.println("Does HashMap contains Twenty One as value: " + map.containsValue("Twenty One")); 
		//Output: Does HashMap contains 21 as key: true 
		//Does HashMap contains 21 as value: false 
		//Does HashMap contains Twenty One as value: true

		//Checking if HashMap is empty
		boolean isEmpty = map.isEmpty(); 
		System.out.println("Is HashMap is empty: " + (isEmpty != true ? "Not empty" : "empty")); 
		//Output: Is HashMap is empty: false

		//Removing Objects from HashMap
		Integer tempkey2 = 21; 
		Object tempvalue = map.remove(tempkey2); 
		System.out.println("Following value is removed from Map: " + tempvalue); 
		//Output: Following value is removed from Map: Twenty One


		//Sorting HashMap
		map.put(21, "Twenty One"); 
		map.put(31, "Thirty One"); 
		map.put(41, "Forty One"); 
		System.out.println("Unsorted HashMap: " + map); 
		TreeMap sortedHashMap = new TreeMap(map); //TreeMap = Sorted Map
		System.out.println("Sorted HashMap: " + sortedHashMap); 
		//Output: Unsorted HashMap: {21=Twenty One, 41=Thirty One, 31=Thirty One} 
		//Sorted HashMap: {21=Twenty One, 31=Thirty One, 41=Thirty One}

	}


	}
		
	
	