package DS1009;

/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano
    @version 3.0
*/
import java.util.*;

public class ArrayStack<T> implements StackInterface<T>
{
   private T[] stack;    // array of stack entries
   private int topIndex; // index of top entry
   private static final int DEFAULT_INITIAL_CAPACITY = 50;
  
   public ArrayStack()
   {
      this(DEFAULT_INITIAL_CAPACITY);
   } // end default constructor
  
   public ArrayStack(int initialCapacity)
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
      topIndex = -1;
  } // end constructor
  
//  < Implementations of the stack operations go here. >
//  . . .

   public void push(T newEntry)
   {
      ensureCapacity();
      topIndex++;
      stack[topIndex] = newEntry;
   } // end push

   private void ensureCapacity()
   {
      
   } // end ensureCapacity

   public T peek()
   {
      T top = null;
     
      if (!isEmpty())
         top = stack[topIndex];
       
      return top;
   } // end peek

   public T pop()
   {
      T top = null;
      if(!this.isEmpty()) {
    	  top=stack[this.topIndex];
    	  stack[this.topIndex]=null;
    	  this.topIndex--;
      }
      
      return top;
   } // end pop

public boolean isEmpty()
{
   return topIndex < 0;
} // end isEmpty


  public void clear()
	{
	  while(!this.isEmpty()) {
		  this.pop();
	  }
      //this.topIndex=-1;
	  
	}


} // end ArrayStack
