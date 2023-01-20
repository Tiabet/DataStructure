package HW6;

import java.util.HashMap;
import java.util.Iterator;

class MyIndex {

    private int x=0; // nr of rows
    private int y=0; // nr of columns
    private int hashvalue = 0;

    public MyIndex (final int x, final int y)
    {
        this.x=x;
        this.y=y;
        hashvalue=((x+"")+(y+"")).hashCode();
    }

    public boolean equals (final Object obj)
    {
    	if(obj instanceof MyIndex) {
      	  MyIndex temp = (MyIndex) obj;
      	  if( this.x==temp.x&&this.y==temp.y) {
      		  return true;
      	  }
        }
  	return false;
    }

    public int hashCode()
    {
    	return hashvalue;
    }

}

public class MySparseMatrix {

    private int rows;
    private int columns;
    private HashMap<MyIndex,Double> values;

    private boolean validIndex (final int row, final int column)
    {
        return (row>=0 && row<rows && column>=0 && column<columns);
    }


    public MySparseMatrix(int rows, int columns)  {
        this.rows=rows;
        this.columns=columns;
        values = new HashMap<MyIndex,Double>(300);
    }

    
    public int getNumberOfRows() {
        return rows;
    }

    public int getNumberOfColumns() {
        return columns;
    }

	public int getNumberofActiveElements() {
		int count=0;
		Iterator<MyIndex> keySetIterator = values.keySet().iterator();
		while(keySetIterator.hasNext()){ 
			MyIndex tempkey = keySetIterator.next(); 
			if(values.get(tempkey)!=null) {
				count++;
			}
		
		} 
		return count;
	}

    
    public double getElement(int row, int column)  {
    	Double myValue = values.get(new MyIndex(row,column));
        if (myValue == null) {
            return 0d;
        } else {
            return myValue.doubleValue();
        }
    }

    
    public void setElement(int row, int column, double value)  { 
        MyIndex temp = new MyIndex(row,column);
        values.put(temp, value);
    }

	public static void main(String[] args){
		MySparseMatrix mat = new MySparseMatrix(10000,500000);
		mat.setElement(3,2, 3.32d);
		mat.setElement(4,7, 4.11d);
		System.out.println("mat.getElement(3,2): " + mat.getElement(3,2));	//should be 3.32d
		System.out.println("mat.getElement(4,7): " + mat.getElement(4,7));	//should be 4.11d
		System.out.println("mat.getElement(1,3): " + mat.getElement(1,3));	//should be zero	
		System.out.println("mat.getNumberofActiveElements() : " + mat.getNumberofActiveElements());	//should be two			
	}
}