package DS1115;

import java.util.HashMap;
import java.util.*;

public class TestDriver4 {

    public static void main(String[] args) {
        // read in the words as an array
        String s = MyTextDataReader.readText("words.txt");
        //System.out.println("" + s);
        //String[] words = s.split("\\s+");
        String[] words = s.split("[\\s,.]+");

        //System.out.println( java.util.Arrays.toString(words) );
        //SortedArrayList<Integer> test = new SortedArrayList<Integer>();
        HashMap<MyString, Counter> map = new HashMap<MyString, Counter>();

        HashSet<Integer> myset2 = new HashSet<Integer>(); //같은게 들어오면 삭제해버리는 HashSet, string의 hashcode를 저장

        for (int i = 0; i < words.length; i++) {
            MyString mystr = new MyString(words[i], 31); //1로 하면 collision이 많이 일어남
            //System.out.println("" + words[i] + ":" + mystr.hashCode());
            //test.insertSorted(mystr.hashCode());
            //test.insertSorted(words[i]);
            myset2.add(mystr.hashCode());

            Counter ct = map.get(mystr);
            if (ct == null) {
                //System.out.println(" new Counter");
                map.put(mystr, new Counter(1));
            } else {
                //System.out.println(" increase()");
                ct.increase();
                //map.put(mystr, ct); 안해줘도 됨
            }
        }

        //System.out.println("president?" + test.contains("president"));
        //System.out.println("Trump?" + test.contains("Trump"));
        //System.out.println("school?" + test.contains("school"));		
        int tempCount = 0;
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            tempCount++;
            Map.Entry<MyString, Counter> thisEntry = (Map.Entry<MyString, Counter>) entries.next();
            MyString key = thisEntry.getKey();
            Counter ct = thisEntry.getValue();
            if (ct.getNum() > 1) {//1개이상인것들만 출력
                System.out.println(tempCount + ":" + key + " " + ct.getNum());
            }
        }

        //System.out.println(test);
        System.out.println("words.length()?" + words.length);
        System.out.println("myset2.size()?" + myset2.size());

    }
}

class Counter {

    private int num;

    Counter(int initial) {
        num = initial;
    }

    public int getNum() {
        return num;
    }

    public void increase() {
        this.num = this.num + 1;
    }
}
