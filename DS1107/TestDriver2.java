package DS1107;

public class TestDriver2
{
	public static void main(String[] args) 
	{
		LinkedGroup<Integer> lg = new LinkedGroup<Integer>();
		lg.add( new Integer(5) );
		lg.add( new Integer(-9) );
		lg.add( new Integer(4) );
		lg.add( new Integer(1) );
		lg.add( new Integer(3) );
		lg.insertionSort();
                System.out.println("Hello World!");
		lg.printAll();

		
	}
}
