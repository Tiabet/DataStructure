package HW1;

import java.util.*;

public class Part3 {
	private MyItem[] bags;
	Part3()	{
		bags = new MyItem[4];
		bags[0]=new MyItem("KAK");
		bags[1]=new	MyItem("dad");
		bags[2]=new	MyItem("Leo");
		bags[3]=new	MyItem("Pow");
		
	}
	
	public void increaseSize() {
		MyItem[] NewItem=new MyItem[bags.length*2];//a,b
		for(int i=0;i<bags.length;i++) {
			NewItem[i]=bags[i];//c,d
		}
		bags=NewItem;//e
		
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
		Part3 tester = new Part3();
		System.out.println(""+tester);
		tester.increaseSize();
		System.out.println(""+tester);
		
	}

}
