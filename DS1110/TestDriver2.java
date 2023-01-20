package DS1110;

public class TestDriver2 {

	public static void main(String[] args) {
		// System.out.println("Hello World!");
		SortedListInterface<String> nameList = new SortList<String>();
		nameList.add("Jamie");
		nameList.add("Brenda");
		nameList.add("Sarah");
		nameList.add("Tom");
		nameList.add("Carlos");
		for (int i = 1; i <= nameList.getLength(); i++) {
			System.out.println("" + nameList.getEntry(i));
		}
		System.out.println("Mark?" + nameList.contains("Mark"));
		System.out.println("Sarah?" + nameList.contains("Sarah"));
		
		/*/
		 * ArrayList를 활용하면 add, contains 등의 함수들을 O(1)로 실행가능한데
		 * LinkedList라 O(n)이 소모됨
		 */
	}
}
