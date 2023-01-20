/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS0930;

import static HW3.MyTextDataReader.readIntValues;

import HW3.Stopwatch;

/**
 *
 * @author TEST
 */
public class TwoSumZero {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("I need a txt file name to read.");
            return;
        }
        Stopwatch timer1 = new Stopwatch();
        int[] dataint = readIntValues(args[0]);
        int count = 0;
        for (int i=0; i < dataint.length ; i++) {
            for (int j=i+1; j < dataint.length ; j++) {
                if (dataint[i] + dataint[j] == 0 ) {
                    count = count + 1;
                    System.out.println(count + ": dataint[" + i + "]=" + dataint[i]);
                    System.out.println(count + ": dataint[" + j + "]=" + dataint[j]);
                }
            }
        }
        double time1 = timer1.elapsedTime();
        //System.out.println( "(" + time1 + " seconds)");
        System.out.printf("(%.5f seconds)\n", time1);     
    }
}
