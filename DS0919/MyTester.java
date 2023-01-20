package DS0919;

import java.util.*;

public class MyTester {
	private MyItem[] bags;
	MyTester()	{
		bags = new MyItem[4];
		bags[0]=new MyItem("KAK");
		bags[1]=new	MyItem("dad");
		bags[2]=new	MyItem("Leo");
		bags[3]=new	MyItem("Pow");
		
	}
	
	public void increaseSize() {
		/*MyItem[] tempArray = new MyItem[bags.length*2];
		for(int i=0;i<bags.length;i++) {
			tempArray[i]=bags[i];
		}
		bags=tempArray;*/
		bags=Arrays.copyOf(bags, bags.length*2);
	}
	
	public String toString() {
		String content = "";
		content="size : "+this.bags.length;
		for(int i=0;i<bags.length;i++) {
			if(bags[i] !=null) {
			content = content + ";" + bags[i].getName()+","+bags[i].toString();
			}
		}
		return content;
	}
	
	public static void main(String[] args) {
		MyTester tester = new MyTester();
		System.out.println(""+tester);
		tester.increaseSize();
		System.out.println(""+tester);
		
	}

}
