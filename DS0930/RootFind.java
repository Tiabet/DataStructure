/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS0930;

/**
 *
 * @author TEST
 */
public class RootFind {
    public static double f(double x) {
        return (x*x-3)*x-1;
    }
    public static void main(String args[]) {
        double r1 = findRoot((double)1, (double)10);
        System.out.println("r1:" + r1);
        System.out.println("f(r1):" + f(r1));
        double r2 = findRoot((double)-1, (double)1);
        System.out.println("r2:" + r2);
        System.out.println("f(r2):" + f(r2));
        double r3 = findRoot((double)-10, (double)-1);
        System.out.println("r3:" + r3);
        System.out.println("f(r3):" + f(r3));

        
    }
    public static double findRoot(double a, double b)
    {//이진검색
        int maxlen = 50;
        double c = (a +b)/2;
        double epsi = Math.pow(10, -7);
        for (int i = 0; i < maxlen; i++) {
            if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
            if ((b - a) < epsi) {
                //System.out.println("b - a " + (b - a));
                System.out.println("["+i + "] Found an interval within epsilon!");
                return (a + b) / 2;
            }
            
            c = (a +b)/2;
        }
        
        return (double) (a+b)/2;
    }
    
    
}
