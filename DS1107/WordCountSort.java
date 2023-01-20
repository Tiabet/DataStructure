package DS1107;

import java.util.*;

public class WordCountSort {

    public static void main(String[] args) {
        /*
        if (args.length < 1) {
            System.out.println("Need a file name");
            return;
        } else {
            args = new String[1];
            args[0] = "mytest.txt";
        }
*/
        args = new String[1];
        args[0] = "mytest.txt";

        // read in the words as an array
        String s = MyTextDataReader.readText(args[0]);
        //String[] words = s.split("\\s+");
        String[] words = s.split("[\\s,.]+");

        System.out.println(java.util.Arrays.toString(words));

        // sort the words
        MergeSort.mergeSort(words);
        //Arrays.sort(words);
        System.out.println( "After sorting");
        System.out.println( java.util.Arrays.toString(words) );

        //System.out.println( "words.length: " + words.length);
        // tabulate frequencies of each word
        //이미 mergeSorting을 했으니까 가능
        Counter[] zipf = new Counter[words.length];
        int m = 0;                                        // number of distinct words
        for (int i = 0; i < words.length; i++) {
            if (i == 0 || !words[i].equals(words[i - 1])) {   // short-circuiting OR
                zipf[m] = new Counter(words[i], words.length);
                m++;
            }
            zipf[m - 1].increment();

        }
        Counter[] zipf2 = Arrays.copyOf(zipf, m );
        // sort by frequency and print

        //System.out.println( "m : " + m);
        //System.out.println( "zipf2 : " + zipf2.length);
        // sorting a subarray
        MergeSort.mergeSort(zipf2);
        //Arrays.sort(zipf2);
        System.out.println( java.util.Arrays.toString(zipf2) );

        //for (int j = m - 2; j >= 0; j--) {
        //    System.out.println(zipf2[j]);
        //}
    }
}
