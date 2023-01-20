package HW5;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowCommon
{	
		public static void ShowCommonElement(ArrayList<String> aList, ArrayList<String> bList) {
			Iterator <String>aiter = aList.iterator();
			
			while(aiter.hasNext()) {
				String str = aiter.next();
				Iterator <String>biter = bList.iterator();//biterator는 while문 안에 선언해줘야 함
				//next() 메소드를 사용하고 초기화를 시켜주는 것
				while(biter.hasNext()) {
					String str2 = biter.next();
					if(str.equals(str2)) {
						System.out.println(str);
					}
				}
			}
		}
		
		public static void main(String[] args) {
			ArrayList<String> aList=new ArrayList<String>();
			ArrayList<String> bList=new ArrayList<String>();
			
			aList.add("Hello");
			aList.add("My");
			aList.add("is");
			bList.add("Hello");
			bList.add("is");
			bList.add("My");
			
			
			ShowCommonElement(aList,bList);
			
		}
}
