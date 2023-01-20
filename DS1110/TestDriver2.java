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
		 * ArrayList�� Ȱ���ϸ� add, contains ���� �Լ����� O(1)�� ���డ���ѵ�
		 * LinkedList�� O(n)�� �Ҹ��
		 */
	}
}
