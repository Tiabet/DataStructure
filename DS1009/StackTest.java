package DS1009;

public class StackTest {

	public static void main(String[] args) {
		StackInterface<String> mystack = new ArrayStack();
		mystack.push("Jim");
        mystack.push("Jess");
        mystack.push("Jill");
        mystack.push("Jane");
        mystack.push("Joe");
        String top = mystack.peek();
        System.out.println("top:" + top);
        top = mystack.pop();
        System.out.println("top by pop():" + top);
        mystack.pop();
        mystack.pop();
        mystack.pop();
        System.out.println("isEmpty():" + mystack.isEmpty());
        mystack.pop();
        System.out.println("isEmpty():" + mystack.isEmpty());

	}

}
