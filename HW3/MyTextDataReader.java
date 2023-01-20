package HW3;

import java.io.*;
import java.util.Arrays;

public class MyTextDataReader {
    public static final int INITIAL_CAPACITY = 4;
    public static int[] increaseSize(int[] dataParam)
    {
        //I am make double the size of the array.
        dataParam = Arrays.copyOf(dataParam, dataParam.length*2);
        return dataParam;
    }
    
    public static int[] readIntValues(String fileName) {
        int[] dataTemp = new int[INITIAL_CAPACITY];
        int HowMany = 0;
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            //int sum = 0;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                try {
                    //
                    if (HowMany == dataTemp.length ) {
                        dataTemp = increaseSize(dataTemp);
                    }
                    dataTemp[HowMany] = Integer.valueOf(strLine.trim() );
                    HowMany = HowMany+1;
                    //sum += Integer.valueOf(strLine);
                } catch (NumberFormatException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                // Print the content on the console
                //System.out.println(strLine);
            }
            //System.out.println("\nSum: " + sum);
            //Close the input stream
            fstream.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        //We need to trim the integer array here!
        dataTemp = Arrays.copyOf(dataTemp, HowMany);
        
        return dataTemp;
    }

    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("I need a txt file name to read.");
            return;
        }
        Stopwatch timer1 = new Stopwatch();
        int[] dataint = readIntValues(args[0]);
        System.out.println("The length is " + dataint.length);
        int sum = 0;
        for (int k=0; k< dataint.length; k++)
        {
            sum = sum + dataint[k];
        }
        System.out.println("The sum is " + sum);
        double time1 = timer1.elapsedTime();
        //System.out.println( "(" + time1 + " seconds)");
        System.out.printf("(%.5f seconds)\n", time1);        
    }
}
