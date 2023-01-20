package DS1110;

public class TestDriver3 {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		// read in the words as an array
		String s = MyTextDataReader.readText("words.txt", " ");
		String[] words = s.split("[\\s]+");

		// System.out.println( java.util.Arrays.toString(words) );
		System.out.println("Length:" + words.length);
		Stopwatch watch = new Stopwatch();

		// sort the words
		MergeSort.mergeSort(words);
		//Sorting을 해줘도 add작업이 아주 느림, arrayList를 사용했으면 BinarySearch같은 걸로 빠르게 add가 가능함
		System.out.println("[1] elapsed time:" + watch.elapsedTime());
		watch = new Stopwatch();
		System.out.println("Adding...");
		SortedListInterface<String> nameList = new SortList<String>();
		for (int i = 0; i < words.length; i++) {
			nameList.add(words[i]); //한 번 진행할 때마다 O(n)이 소모됨, 이걸 n번 하므로 사실상 O(n^2)
		}
		System.out.println("[2] elapsed time:" + watch.elapsedTime());

		for (int i = 1; i <= nameList.getLength(); i++) {
			System.out.println("" + nameList.getEntry(i));
		}
		System.out.println("school?" + nameList.contains("school"));
		System.out.println("schoool?" + nameList.contains("schoool"));
	}
}
