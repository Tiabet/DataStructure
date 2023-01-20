package DS0920;

public class MyNodeTester {

	public static void main(String[] args) {
		MyNode<String> node1 = new MyNode<String> ("num1");
		MyNode<String> node2 = new MyNode<String> ("num2",node1);
		MyNode<String> node3 = new MyNode<String> ("num3",node2);
		
		MyNode tempNode = node3.getNextNode();
		System.out.println("tempnode : "+tempNode.getData());

	}

}
