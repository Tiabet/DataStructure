import java.io.*;
import java.util.*;
//��� ������ 1 == no solution�� value, 0 == ���� varaiable
public class ReadResult{
	static SparseMatrix mat = new SparseMatrix(80000,3002); // ���� ù �� ������ ������� solution value, time �� �ڿ� solution variable (0,0) = ù solution value

	public static void setSvalue(int row, int column, Double dValue){
		// 1�� ���� ��� txt���Ͽ��� ������ ���� ������ �ǹ� �׷����� ������ �ʿ����, 1�� �ƴѰ�츸 ����
		if(dValue!=1) {
			//3001��°�κ��� ������� ��ȯ 0���� ����
			if(column==3000){
				mat.setElement(row, 0, dValue);
			}
			else if(column==3001){
				mat.setElement(row, 1, dValue);
			}
			else{
				mat.setElement(row, column+2, dValue);
			}
		}
	} //end of setSvalue method
	
	public static SparseMatrix GetMatrix() {
		// Get file path using relative path
		String filePath = "./data/resultsample.txt";
		File file = new File(filePath);
		Double dValue = 0.00;
		int rowCount = 0; //������ (0,2)���� 0
		int columnCount = 0; //������ (0,2)���� 2
		//read file using stream
		try(Scanner sc = new Scanner(new FileInputStream(file))){
			
			while(sc.hasNext()){
//				//read 1line by 1line
				while(sc.hasNext()&&columnCount<3002){
					String sValue = sc.next();
					try{
						//sc.next�� �⺻������ string�� ��ȯ�ϱ⿡ �ٽ� double Ÿ������ ��ȯ
						dValue = Double.parseDouble(sValue);
						setSvalue(rowCount, columnCount, dValue);
					}//end of try
					catch (Exception e){
					    //������ ����
//						e.printStackTrace(); //���� ���
						 //System.out.println("���� ����" + sValue);
					     //System.out.println("���� ����:" + columnCount);
						// 0�� �Ѿ��� ����� �������� 0���� ��ȯ -> lp ������ ���� ������� ���� ǥ��
						//no Solution�� ��쿡�� 0 ��ȯ
						if(sValue.equals("no")){
							dValue = 0.00;
							setSvalue(rowCount, columnCount, dValue);
						}else if(sValue.equals("solution")) {
							columnCount--;
						}
						//format ���� 8 1.00+e04
						//1.14e-04-9.62e-20 �� ����� error��� ���� ���� �޺κ��� ���� ���̱⿡ 0���� ó��
						else{
							String sValue1 = sValue.substring(0, 8);
							String sValue2 = sValue.substring(8, 17);
							//System.out.println("���� ����" + sValue1);
						    //System.out.println("���� ����:" + sValue2);
							Double dValue1 = Double.parseDouble(sValue1);
							Double dValue2 = 0.00;
							setSvalue(rowCount, columnCount, dValue1);
							columnCount ++;
							setSvalue(rowCount, columnCount, dValue2);
						} //end of else statement
					}//end of catch statement
					columnCount ++; //3001���� ��ȸ��
				} //end of while
				columnCount = 0;
				rowCount ++; 
			} //end of while
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print("���� " + mat.getElement(36, 1));
		return mat;
	}
	//end of GetMatrix
}
