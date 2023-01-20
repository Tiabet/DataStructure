package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MostOccurenceElement {
	
	public static void FindMostOccurence(ArrayList<String> sList) {
		Iterator<String> siter = sList.iterator();
		String word = null;
		int max=0;
		while(siter.hasNext()) {
			String str = siter.next();
			
			int nameCount=0;
			
			Iterator<String> citer = sList.iterator();
			while(citer.hasNext()) {
				String nextWord = citer.next();
				if(nextWord.equals(str)){
					nameCount++;
				}
			}
			if(nameCount>max) {
				max=nameCount;
				word = str;
			}
			}
		System.out.println(word+" "+max+"번 출력되었습니다");
		}
		
	

	public static void main(String[] args) {
		String[] arr = {"I", "like", "school", "love", "apple", "bear", "like", "go", "hello", "world", "like", "like"};
		ArrayList <String>sList = new ArrayList<String> (Arrays.asList(arr));
		
		FindMostOccurence(sList);

	}

}
