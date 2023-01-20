package HW1;

import java.io.*;

public class Part1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mydata1.txt"));
		//use bufferedreader to read "mydata1.txt"
		
		
		String str;
		int count=0;
		while((str=br.readLine())!=null) {
			String[] words = str.split(" ");
			count+=words.length;
		} //make array named "words" in while loop to use split method.
		System.out.println(count);
	}

}
