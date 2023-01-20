package DS1110;

public class TestDriver4 {

	public static void main(String[] args) {
		SortedArrayList<String> test = new SortedArrayList<String>();

		test.insertSorted("Jamie");
		System.out.println(test);
		test.insertSorted("Brenda");
		System.out.println(test);
		test.insertSorted("Sarah");
		System.out.println(test);
		test.insertSorted("Tom");
		System.out.println(test);
		test.insertSorted("Carlos");
		System.out.println(test);

		for (int i = 0; i < test.size(); i++) {
			System.out.println("" + test.get(i));
		}
		System.out.println("Mark?" + test.contains("Mark"));
		System.out.println("Sarah?" + test.contains("Sarah"));

		System.out.println("Mark?" + test.mycontains("Mark"));
		System.out.println("Sarah?" + test.mycontains("Sarah"));
	}
}
