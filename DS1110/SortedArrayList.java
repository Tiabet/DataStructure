package DS1110;

import java.util.*;

class SortedArrayList<T> extends ArrayList<T> {
	/*
	 * LinkedList의 시간이 오래 걸린다는 단점을 보완함!
	 */

	@SuppressWarnings("unchecked")
	public void insertSorted(T value) {
		add(value);
		Comparable<T> cmp = (Comparable<T>) value;
		for (int i = size() - 1; i > 0 && cmp.compareTo(get(i - 1)) < 0; i--)
			Collections.swap(this, i, i - 1); //삽입정렬 메소드를 사용해서 정렬을 진행함
		//swap 메소드는 this가 list고, list의 i와 그 앞의 것을 스왑하는 것.
	}

	private boolean binarySearch(int first, int last, T desiredItem) {
		boolean found;
		int mid = first + (last - first) / 2;
		Comparable<T> cmp = (Comparable<T>) desiredItem;

		if (first > last)
			found = false;
		else if (cmp.equals(get(mid)))
			found = true;
		else if (cmp.compareTo(get(mid)) < 0)
			found = binarySearch(first, mid - 1, desiredItem);
		else
			found = binarySearch(mid + 1, last, desiredItem);

		return found;
	} // end binarySearch

	public boolean mycontains(T anEntry) {
		return binarySearch(0, size() - 1, anEntry);
	}
}