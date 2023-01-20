package DS1110;

import java.util.ArrayList;

public class ArrayListTest {
	private static ArrayList<Integer> mArrayList;

	public static void main(String[] args) {

		// ArrayList 생성
		mArrayList = new ArrayList<Integer>();

		// ArrayList 값 추가
		mArrayList.add(10);
		mArrayList.add(20);
		mArrayList.add(30);
		mArrayList.add(40);
		mArrayList.add(50);
		System.out.println();

		// ArrayList 값 확인
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("one index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList 특정 index 값 제거
		mArrayList.remove(0);
		// 0번째 index가 지워지면서 자동으로 1번이 0번째 index가 되었다.
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("two index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList 특정 index 값 추가
		mArrayList.add(0, 7777);
		// 0번째 index가 추가되고 나머지 index들은 뒤로 밀린다.
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("three index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList 특정 index 값 수정
		mArrayList.set(0, 77779);
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("four index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Value 포함 여부 확인
		Integer checkNumber = new Integer(99999);
		mArrayList.add(checkNumber);
		boolean isFind = mArrayList.contains(checkNumber);
		System.out.println("five : " + isFind + "\n");
		for (int i = 0; i < mArrayList.size(); i++) {
			System.out.println("five index " + i + " : value " + mArrayList.get(i));
		}
		System.out.println();

		// ArrayList Value index 확인
		int index = mArrayList.indexOf(checkNumber);
		System.out.println("six : index " + index + "\n");

		// ArrayList swap
		System.out.println("before swapping, " + mArrayList);
		java.util.Collections.swap(mArrayList, 3, 5);
		System.out.println("after swapping, " + mArrayList);

		// ArrayList 값 전체 삭제
		mArrayList.clear();
		System.out.println("seven : size " + mArrayList.size() + "\n");

		// ArrayList의 값 존재 여부 확인
		boolean isEmpty = mArrayList.isEmpty();
		System.out.println("eight : empty " + isEmpty + "\n");
	}
}