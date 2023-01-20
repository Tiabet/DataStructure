package DS1108;

import java.util.ArrayList;
 
public class ArrayListUsing {     
    private static ArrayList<Integer> mArrayList;
 
    public static void main(String[] args) {         
         
        // ArrayList ����
        mArrayList = new ArrayList<Integer>();
         
        // ArrayList �� �߰�
        mArrayList.add(1); //autoboxing
        mArrayList.add(2);
        mArrayList.add(3);
        mArrayList.add(4);
        mArrayList.add(5);
        System.out.println();
         
        // ArrayList �� Ȯ��
        for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("one index " + i + " : value " + mArrayList.get(i));
        }
        System.out.println();         
         
        // ArrayList Ư�� index �� ����
        mArrayList.remove(0);
        // 0��° index�� �������鼭 �ڵ����� 1���� 0��° index�� �Ǿ���.
        for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("two index " + i + " : value " + mArrayList.get(i));
        }
        System.out.println();
         
         
        // ArrayList Ư�� index �� �߰�
        mArrayList.add(0, 7777);
        // 0��° index�� �߰��ǰ� ������ index���� �ڷ� �и���.
        for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("three index " + i + " : value " + mArrayList.get(i));
        }
        System.out.println();
         
         
        // ArrayList Ư�� index �� ����
        mArrayList.set(0, 77779);
        for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("four index " + i + " : value " + mArrayList.get(i));
        }
        System.out.println();         
         
         
        // ArrayList Value ���� ���� Ȯ��
        Integer checkNumber = new Integer(99999);
        mArrayList.add(checkNumber);
        boolean isFind = mArrayList.contains(checkNumber);
        System.out.println("five : " + isFind + "\n");
        for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("five index " + i + " : value " + mArrayList.get(i));
        }
        System.out.println();
         
         
        // ArrayList Value index Ȯ��
        int index = mArrayList.indexOf(checkNumber);
        System.out.println("six : index " + index + "\n");
         
         
        // ArrayList �� ��ü ����
        mArrayList.clear();
        System.out.println("seven : size " + mArrayList.size() + "\n");
         
         
        // ArrayList�� �� ���� ���� Ȯ��
        boolean isEmpty = mArrayList.isEmpty();
        System.out.println("eight : empty " + isEmpty + "\n");
    } 
}