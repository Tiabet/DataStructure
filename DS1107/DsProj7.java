/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS1107;

/**
 *
 * @author TEST
 */
public class DsProj7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] mydata = {4, 7, 1, 10, -1, 39, 23};
        MySelectionSort.<Integer>selectionSort(mydata, mydata.length-1);
        for (int i=0 ; i < mydata.length ; i++ ) {
            System.out.println("" + mydata[i]);
        }
    }
    
}
