package DS1123;

public class  TestDriver1
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		MaxHeap<Integer> maxh = new MaxHeap<Integer>();
		maxh.add(5);
		System.out.println("getSize(): " + maxh.getSize() );
		System.out.println("getMax(): " + maxh.getMax() );
		
		maxh.add(4);
		System.out.println("getSize(): " + maxh.getSize() );
		System.out.println("getMax(): " + maxh.getMax() );
		
		maxh.add(7);
		System.out.println("getSize(): " + maxh.getSize() );
		System.out.println("getMax(): " + maxh.getMax() );

		maxh.add(1);
		System.out.println("getSize(): " + maxh.getSize() );
		System.out.println("getMax(): " + maxh.getMax() );

		System.out.println("removeMax(): " + maxh.removeMax() );
		System.out.println("removeMax(): " + maxh.removeMax() );
		System.out.println("removeMax(): " + maxh.removeMax() );
		System.out.println("removeMax(): " + maxh.removeMax() );		
		System.out.println("removeMax(): " + maxh.removeMax() );		

	}
}
