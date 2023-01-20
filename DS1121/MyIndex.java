package DS1121;

import java.util.HashMap;

public class MyIndex {

    private int x=0; // nr of rows
    private int y=0; // nr of columns
    private int hashvalue = 0;

    public MyIndex (final int x, final int y)
    {
        this.x=x;
        this.y=y;
        hashvalue=((x+"")+(y+"")).hashCode();//충돌이 약간 일어날 수가 있음
    }

    public boolean equals(final Object obj)
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
    
    public static void main(String[] args){
		MySparseMatrix mat = new MySparseMatrix(10000,500000);
		mat.setElement(3,2, 3.32d);
		mat.setElement(4,7, 4.11d);
		System.out.println("mat.getElement(3,2): " + mat.getElement(3,2));	//should be 3.32d
		System.out.println("mat.getElement(4,7): " + mat.getElement(4,7));	//should be 4.11d
		System.out.println("mat.getElement(1,3): " + mat.getElement(1,3));	//should be zero	
		//System.out.println("mat.getNumberofActiveElements() : " + mat.getNumberofActiveElements());	//should be two			
	}

}

class MySparseMatrix {

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
        //to-do
        values = new HashMap<MyIndex,Double>(300);
    }

    
    public int getNumberOfRows() {
        return rows;
    }

    public int getNumberOfColumns() {
        return columns;
    }

    /*
	public int getNumberofActiveElements() {
		//to-do
	}
	*/

    
    public double getElement(int row, int column)  {
    	double result;
        result= values.get(new MyIndex(row,column));
        
        return result;
    }
   

    
    public void setElement(int row, int column, double value)  {  
        this.values.put(new MyIndex(row,column),value);
    }


}
