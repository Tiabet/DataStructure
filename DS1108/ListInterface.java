package DS1108;

public interface ListInterface<T>
{
   public void add(T newEntry);
   public boolean add(int newPosition, T newEntry);
   public T remove(int givenPosition);
   public void clear();
   public boolean replace(int givenPosition, T newEntry);
   public T getEntry(int givenPosition);
   public boolean contains(T anEntry);
   public int getLength();
   public boolean isEmpty();
   public T[] toArray();   
} // end ListInterface
