package DS1123;

import java.util.*;

public class  TestDriverBST
{

   public static void main(String[] args)
   {
     /* Integer[] a = {1,5,2,7,4};
      BST<Integer> bst = new BST<Integer>();
      for(Integer n : a) bst.insert(n);

      bst.preOrderTraversal();
      System.out.println();

      //testing comparator
      //build a mirror BST with a rule:  Left > Parent > Right
      //code for the comparator at the bottom of the file
      bst = new BST<Integer>(new MyComp1());
      for(Integer n : a) bst.insert(n);

      System.out.println("preOrderTraversal");
	  bst.preOrderTraversal();
	  System.out.println();
      System.out.println("inOrderTraversal");
      bst.inOrderTraversal();	  
      System.out.println();
	  System.out.println("bst.search(3):" + bst.search(3) );
	  System.out.println("bst.search(5):" + bst.search(5) );
	  

      for(Integer n : bst) System.out.print(n);
      System.out.println();

      System.out.println(bst);*/

      /*
	  //testing restoring a tree from two given traversals
      bst.preOrderTraversal();
      System.out.println();
      bst.inOrderTraversal();
      System.out.println();

      //testing diameter
      System.out.println("diameter = " + bst.diameter());
      //testing width
      System.out.println("width = " + bst.width());
	  */

	  task1();
	  //task2();
	  task3();

   }
   
   //BST를 사용해 작업

   public static void task1()
	{
	  System.out.println("---------task1");
	  int MAXNUM = 1000000;

	  Stopwatch timer1 = new Stopwatch();
	  Random randomNumber = new Random(System.currentTimeMillis());
	  BST<Integer> bst2 = new BST<Integer>();
      int HowManyDuplicated = 0;
	  for(int i=0; i < MAXNUM; i++) {
		  int value = randomNumber.nextInt( 10*MAXNUM );
		  if( bst2.search(value) )
		  {
			  HowManyDuplicated++;
		  } else {
			bst2.insert(value);
		  }
	  }
      //System.out.println("inOrderTraversal");
      //bst2.inOrderTraversal();	  

      int found = 0;
	  for(int i=0; i < MAXNUM; i++) {
		  int value = i;
		  if (bst2.search(value))
		  {
			  found++;
		  } 
	  }
	  System.out.println("how many found: " + found);
	  System.out.println("HowManyDuplicated: " + HowManyDuplicated);
	  System.out.println("ratio: " + (float) found/(10*MAXNUM - HowManyDuplicated) );
	  
      double time1 = timer1.elapsedTime();
      System.out.printf("(%.2f seconds)\n", time1);

	}

   //LinkedList로 구현하면 아주아주 느려짐
   public static void task2()
	{
	  System.out.println("---------task2");
	  int MAXNUM = 1000000;

	  Stopwatch timer1 = new Stopwatch();
	  Random randomNumber = new Random(System.currentTimeMillis());
	  LinkedList<Integer> mylist = new LinkedList<Integer>();
      int HowManyDuplicated = 0;
	  for(int i=0; i < MAXNUM; i++) {
		  int value = randomNumber.nextInt( 10*MAXNUM );
		  if( mylist.contains(value) )
		  {
			  HowManyDuplicated++;
		  } else {
			mylist.add(value);
		  }
	  }
      //System.out.println("inOrderTraversal");
      //bst2.inOrderTraversal();	  

      int found = 0;
	  for(int i=0; i < MAXNUM; i++) {
		  int value = i;
		  if (mylist.contains(value))
		  {
			  found++;
		  } 
	  }
	  System.out.println("how many found: " + found);
	  System.out.println("HowManyDuplicated: " + HowManyDuplicated);
	  System.out.println("ratio: " + (float) found/(10*MAXNUM - HowManyDuplicated) );
	  
      double time1 = timer1.elapsedTime();
      System.out.printf("(%.2f seconds)\n", time1);

	}


   //TreeSet도 빠르게 가능
   public static void task3()
	{
	  System.out.println("---------task3");
	  int MAXNUM = 1000000;

	  Stopwatch timer1 = new Stopwatch();
	  Random randomNumber = new Random(System.currentTimeMillis());
	  TreeSet<Integer> treeset = new TreeSet<Integer>();
      int HowManyDuplicated = 0;
	  for(int i=0; i < MAXNUM; i++) {
		  int value = randomNumber.nextInt( 10*MAXNUM );
		  if( !treeset.add(value) )
		  {
			  HowManyDuplicated++;
		  } 
	  }
      //System.out.println("inOrderTraversal");
      //bst2.inOrderTraversal();	  

      int found = 0;
	  for(int i=0; i < MAXNUM; i++) {
		  int value = i;
		  if (treeset.contains(value))
		  {
			  found++;
		  } 
	  }
	  System.out.println("how many found: " + found);
	  System.out.println("HowManyDuplicated: " + HowManyDuplicated);
	  System.out.println("ratio: " + (float) found/(10*MAXNUM - HowManyDuplicated) );
	  
      double time1 = timer1.elapsedTime();
      System.out.printf("(%.2f seconds)\n", time1);

	}


}
