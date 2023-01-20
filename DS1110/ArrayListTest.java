package DS1110;

import java.util.ArrayList;

public class ArrayListTest {
	private static ArrayList<Integer> mArrayList;

	public static void main(String[] args) {

		// ArrayList ����
		mArrayList = new ArrayList<Integer>();

		// ArrayList �� �߰�
		mArrayList.add(10);
		mArrayList.add(20);
		mArrayList.add(30);
		mArrayList.add(40);
		mArrayList.add(50);
		System.out.println();

		// ArrayList �� Ȯ��
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("one index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Ư�� index �� ����
		mArrayList.remove(0);
		// 0��° index�� �������鼭 �ڵ����� 1���� 0��° index�� �Ǿ���.
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("two index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Ư�� index �� �߰�
		mArrayList.add(0, 7777);
		// 0��° index�� �߰��ǰ� ������ index���� �ڷ� �и���.
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("three index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Ư�� index �� ����
		mArrayList.set(0, 77779);
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("four index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Value ���� ���� Ȯ��
		Integer checkNumber = new Integer(99999);
		mArrayList.add(checkNumber);
		boolean isFind = mArrayList.contains(checkNumber);
		System.out.println("five : " + isFind + "\n");
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("five index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Value index Ȯ��
		int index = mArrayList.indexOf(checkNumber);
		System.out.println("six : index " + index + "\n");

		// ArrayList swap
		System.out.println("before swapping, " + mArrayList);
		java.util.Collections.swap(mArrayList, 3, 5);
		System.out.println("after swapping, " + mArrayList);

		// ArrayList �� ��ü ����
		mArrayList.clear();
		System.out.println("seven : size " + mArrayList.size() + "\n");

		// ArrayList�� �� ���� ���� Ȯ��
		boolean isEmpty = mArrayList.isEmpty();
		System.out.println("eight : empty " + isEmpty + "\n");
	}
}