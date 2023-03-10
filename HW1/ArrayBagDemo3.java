package HW1;

/** A test of the methods remove and clear, as defined in the class ArrayBag.
    Assumes the remaining methods are correct.
    @author Frank M. Carrano
    @version 3.0
*/
public class ArrayBagDemo3
{
	public static void main(String[] args) 
	{
   // a bag that is not full
		BagInterface<String> aBag = new ArrayBag<String>();
      
      // Removing a string from an empty bag:
      String[] testStrings1 = {"", "B"};
      testRemove(aBag, testStrings1);

      // adding strings
		String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
		testAdd(aBag, contentsOfBag1);
		
      // removing strings
		String[] testStrings3 = {"", "B", "A", "C", "Z"};
      testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();
      testIsEmpty(aBag, true);
 		testIsFull(aBag, false);
		displayBag(aBag);

	//----------------------------------------------------------------------

		// a bag that will be full
		aBag = new ArrayBag<String>(7);
      System.out.println("\nA new empty bag:");

      // Removing a string from an empty bag:
      testRemove(aBag, testStrings1);

      // adding strings
		String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D"};
		testAdd(aBag, contentsOfBag2);
		
      // removing strings
		System.out.println("\nRemoving strings:");
      testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();

      testIsEmpty(aBag, true);
 		testIsFull(aBag, false);
		displayBag(aBag);
	} // end main
	
   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

   // Tests the two remove methods.
	private static void testRemove(BagInterface<String> aBag, String[] tests)
	{
      System.out.println("\nTesting the two remove methods:");
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (aString.equals("") || (aString == null))
         {
            // test remove()
            System.out.println("\nRemoving a string from the bag:");
            String removedString = aBag.remove();
            System.out.println("remove() returns " + removedString);
         }
         else
         {
            // test remove(aString)
            System.out.println("\nRemoving \"" + aString + "\" from the bag:");
            boolean result = aBag.remove(aString);
            System.out.println("remove(\"" + aString + "\") returns " + result);
         } // end if
         
         displayBag(aBag);
      } // end for
	} // end testRemove

   // Tests the method isEmpty.
   // correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("\nTesting the method isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
	} // end testIsEmpty

   // Tests the method isFull.
   // correctResult indicates what isFull should return.   
	private static void testIsFull(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("\nTesting the method isFull with ");
      if (correctResult)
         System.out.println("a full bag:");
      else
         System.out.println("a bag that is not full:");
      
      System.out.print("isFull finds the bag ");
      if (correctResult && aBag.isFull())
			System.out.println("full: OK.");
		else if (correctResult)
			System.out.println("not full, but it is full: ERROR.");
		else if (!correctResult && aBag.isFull())
			System.out.println("full, but it is not full: ERROR.");
		else
			System.out.println("not full: OK.");      
	} // end testIsFull

   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end ArrayBagDemo
