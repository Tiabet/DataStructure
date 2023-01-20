package DS1115;

import java.util.HashSet;

public class DsProj11 {


    public static void main(String[] args) {
        // TODO code application logic here
		HashSet<String> myset = new HashSet<String>();
		myset.add(new String("hello"));
                myset.add(new String("hello1"));
                myset.add(new String("hello2"));
                myset.add(new String("hello1"));
                myset.add(new String("hello2"));
                
        	//iterate through HashSet
        	for(String str : myset) {
            		System.out.println(str);
		}

    }
    
}
