package Ds1111;

import java.util.Arrays;
import java.io.*;

public class  MyTextDataReader
{
	static int INITIAL_CAPACITY = 3;

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		int[] vals = readIntValues("1Kints.txt");
		for (int i=0; i < vals.length ; i++ )
		{
			System.out.println( vals[i]);
		}
		System.out.println("length:" + vals.length);		
	}

	public static int[] DoubleTheSize(int[] prevData)
	{
		return Arrays.copyOf(prevData, prevData.length *2);
	}

  public static int[] readIntValues(String fileName) {
	  int[] MyData = new int[INITIAL_CAPACITY];
	  int HowMany = 0;
    try{	
      FileInputStream fstream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;
      
      //Read File Line By Line
      while ((strLine = br.readLine()) != null) {
        try {
			if ( MyData.length == HowMany)
			{
				MyData = DoubleTheSize(MyData);
			}
          
		  MyData[HowMany] = Integer.valueOf(strLine.trim());
		  HowMany = HowMany + 1;
        } catch (NumberFormatException e){
          System.err.println("Error: " + e.getMessage());
        }
        // Print the content on the console
        //System.out.println(strLine);

      }
      System.out.println("\n HowMany: "+HowMany);

      //Close the input stream
      fstream.close();
    } catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
	return Arrays.copyOf(MyData, HowMany);
  }

  public static String readText(String fileName) {	  
	return readText(fileName, "");
  }

  public static String readText(String fileName, String appendLineStr ) {
	  StringBuffer MyData = new StringBuffer();
    try{	
      FileInputStream fstream = new FileInputStream(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;
      
      //Read File Line By Line
      while ((strLine = br.readLine()) != null) {
        try {
			MyData.append(strLine + appendLineStr);
        } catch (NumberFormatException e){
          System.err.println("Error: " + e.getMessage());
        }
      }
      //Close the input stream
      fstream.close();
    } catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
	return MyData.toString();
  }

}
