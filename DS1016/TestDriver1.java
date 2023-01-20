/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS1016;

/**
 *
 * @author TEST
 */
public class TestDriver1 {
    public static long[] myfibo = new long[500];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //doTask1();
        //doTask2();
        //doTask3();
        //doTask4();
        doTask5();
    }
    public static void doTask5() {
        String myset = "abcde";
        FindSubsequence(myset, 3);
    }
    public static void FindSubsequence(String str, int Number) {
        print("", str, 3);
    }
    public static void print(String prefix, String remaining, int k) {//k는 남은 글자수
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        if (remaining.length() == 0) return;
        print(prefix + remaining.charAt(0), remaining.substring(1), k-1);//prefix에다 글자를 추가해나가는 방식
        print(prefix, remaining.substring(1), k);//substring(index)는 index이후의 문자열을 남겨주는 방식
    }

    public static void doTask4() {
        long myval = ComputeFibonacci(25);//26번째가 출력됨
        System.out.println("" + Long.MIN_VALUE);
        System.out.println("" + Long.MAX_VALUE);
        System.out.println("myval:" + myval);
    }
    public static long ComputeFibonacci(int index) {
    	
    	/*if(index<=1	) {
    		return 1;
    	} else {
    		return ComputeFibonacci(index-1)+ComputeFibonacci(index-2);
    	}
    	재호출되는과정 때문에 매우 비효율적인 과정
    	*/
    	
        if (index <= 1) {
            myfibo[0] = 1; //myfibo를 길이가 아주 긴 배열로 선언해놓음
            myfibo[1] = 1;
            return 1;
        }
        if (myfibo[index] == 0 ) { //결국엔 0부터 구해가는 방식으로 recursion을 진행함
            long val1 = ComputeFibonacci(index-1) + ComputeFibonacci(index-2);
            myfibo[index] = val1;
            return val1; 
        } else {
            return myfibo[index];
        } //피보나치 수열을 recursive로 하는 것은 아주 비효율적이지만, 값을 저장해나가는 식으로 하면 계산을 일일이 안 하기 때문에 빠름
    }
    
    public static void doTask3() {
        int gcd = FindGCD(6,15);
        System.out.println("gcd:" + gcd);
    }
    public static int FindGCD(int a, int b) {
    	if(a<b) {
    		int c=b;
    		b=a;
    		a=c;
    	}
        if ( b == 0 ) {
            return a;
        }
        return FindGCD(b , a % b);
    }
    
    public static void doTask2() {
        String mystr = "hello";
        //System.out.println("" + mystr.substring(0, mystr.length()));
        //System.out.println("" + mystr.substring(0, mystr.length()-1));
        printReverse(mystr);
    }
    public static void printReverseIter(String str) {
        for (int i=0; i < str.length(); i++){
            System.out.println("" + str.charAt(str.length() -1 - i));
        }//거꾸로 출력하는 iteration
    }
    public static void printReverse(String str) {
        if ( str.length() == 1) {
            System.out.println("" + str);
            return;
        }
        System.out.println("" + str.charAt(str.length() -1));
        printReverse(str.substring(0, str.length()-1)); //잘개 쪼개는 느낌이 아니고 길이를 줄여가면서 출력
    }
    
    
    public static void doTask1() {
        int[] mydata = new int[10];
        mydata[0] = 5;
        mydata[1] = 1;
        mydata[2] = 6;
        mydata[3] = 2;
        mydata[4] = 8;
        mydata[5] = 8;
        mydata[6] = 6;
        mydata[7] = 4;
        mydata[8] = 3;
        mydata[9] = 9;
        displayArray(mydata);
    }

    public static void showArray(int[] data) {
        System.out.println("");
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println(""); //iterative하게 출력하는 방법
    }
    public static void displayArray(int[] data) {
        System.out.println("");
        displayArray(data, 0, data.length-1);
        System.out.println(""); //recursive하게 출력하는 방법
    }

    public static void displayArray(int[] array, int first, int last) {
        if (first == last) {
            System.out.print(array[first] + " "); //breaking condition이 recursion에서는 필수	
        } else {
            int mid = (first + last) / 2;
            displayArray(array, first, mid);
            displayArray(array, mid + 1, last); //아주 잘게잘게 쪼개는 느낌
        } // end if
    } // end displayArray
    

}
