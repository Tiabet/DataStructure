package Ds1111;

public class TestDriver3 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // read in the words as an array
        String s = MyTextDataReader.readText("words.txt", " ");
        String[] words = s.split("[\\s]+");

        //System.out.println( java.util.Arrays.toString(words) );
        System.out.println("Length:" + words.length);
        Stopwatch watch = new Stopwatch();

        // sort the words
        MergeSort.mergeSort(words);
        System.out.println("[1] elapsed time:" + watch.elapsedTime());
        watch = new Stopwatch();
        System.out.println("Adding...");
        SortedListInterface<String> nameList = new SortList<String>();
        for (int i = 0; i < words.length; i++) {
            nameList.add(words[i]);
        }
        System.out.println("[2] elapsed time:" + watch.elapsedTime());

        for (int i = 1; i <= nameList.getLength(); i++) {
            System.out.println("" + nameList.getEntry(i));
        }
        System.out.println("school?" + nameList.contains("school"));
        System.out.println("schoool?" + nameList.contains("schoool"));
    }
}
