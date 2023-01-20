	package DS1110;

public class TestDriver5 {

	public static void main(String[] args) {
		/*
		 * LinkedList������������� �ξ� ����
		 */
		System.out.println("Hello World!");
		// read in the words as an array
		String s = MyTextDataReader.readText("words.txt", " ");
		String[] words = s.split("[\\s]+");

		// System.out.println( java.util.Arrays.toString(words) );
		System.out.println("Length:" + words.length);

		// sort the words
		Stopwatch watch = new Stopwatch();
		MergeSort.mergeSort(words);
		System.out.println("[1] elapsed time:" + watch.elapsedTime());
		watch = new Stopwatch();

		System.out.println("Adding...");
		SortedArrayList<String> nameList = new SortedArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			nameList.insertSorted(words[i]); //������ mergesort�������Ƿ� O(1)�� ����� �� ����
		}
		System.out.println("[2] elapsed time:" + watch.elapsedTime());

		// for (int i=1; i<= nameList.size() ; i++)
		// {
		// System.out.println("" + nameList.get(i));
		// }
		System.out.println("school?" + nameList.mycontains("school"));
		System.out.println("School?" + nameList.mycontains("School"));
		System.out.println("schoool?" + nameList.mycontains("schoool"));
	} 
}
