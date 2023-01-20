package HW3;

import java.io.*;

class FileRead2 {

    public static void main(String args[]) {
        try {
            FileInputStream fstream = new FileInputStream("Numbers.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int sum = 0;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                try {
                    sum += Integer.valueOf(strLine);
                } catch (NumberFormatException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                // Print the content on the console
                System.out.println(strLine);

            }
            System.out.println("\nSum: " + sum);

            //Close the input stream
            fstream.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
