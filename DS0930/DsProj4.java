/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS0930;

import HW3.Stopwatch;

/**
 *
 * @author TEST
 */
public class DsProj4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Loop A
        int n = Integer.parseInt(args[0]);
        int sum = 0;
        //int n = 10;
        Stopwatch timer1 = new Stopwatch();
        for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= n; j++) {
              sum = sum + j;
           }
        }
        double time1 = timer1.elapsedTime();
        //System.out.println("sum:" + sum);
        System.out.printf("%.3f seconds\n", time1);
    }
    
}
