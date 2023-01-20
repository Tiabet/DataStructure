package Ds1111;

import java.util.Arrays;

public class TestDriverBN
{
	public static void main(String[] args) 
	{
		Integer[] data1 = {6, 1, 2, 10, 11, 55, 21, 42, 7};
		System.out.println("before sorted: " + Arrays.toString(data1));
		MergeSort.mergeSort(data1);
		//Arrays.sort(data1);

		System.out.println("sorted: " + Arrays.toString(data1));
		int result = MyBinarySearcher.searchVer2(data1, 0, data1.length-1, 7);
		System.out.println("search result for 7: " + result);
		int result2 = MyBinarySearcher.searchVer1(data1, 0);
		System.out.println("search result2 for 7: " + result2);
	}
}
