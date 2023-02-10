import java.util.Scanner;
import TeamProject.ReadResult;

public class InvestService {

	static SparseMatrix mat = ReadResult.GetMatrix();// InvestService�� matrix�� ReadResult�� �����Ѵ�. 
	//public static�̶� import�� ��ü ���� ���� �ٷ� ��� ����.

	//��ü�� �����ϸ鼭 �ٷ� ���� ����
	public InvestService() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("������ ���� �˰� �ͽ��ϱ�?");
			System.out.println("(1)Ư�� ������ ���ؼ� (2)Ư�� ������ ���ؼ� (0)���� ����");
			int menu = sc.nextInt();
			if (menu == 0)
				break;
			int x;
			int var;
			switch (menu) {
			case 1:
				System.out.println("�� �� ����(1~80000)�� ���ؼ� �˰� �ͽ��ϱ�? ������ ���� ���� �˰� �����ø� 0�� �Է��ϼ���.");
				var = sc.nextInt();
				System.out.println(var + "�� ������ ������ ���� �˰� �ͽ��ϱ�?");
				System.out.println("(1)������ �ð� (2)������ Ǯ�ȴ��� ���� (3)������ �����İ��� (4)������ ������ ���� (5)��ü ������ ��� �ɸ� �ð�");
				x = sc.nextInt();
				ProblemService(x,var);
				break;

			case 2:
				System.out.println("�� �� ����(1~3000)�� ���ؼ� �˰� �ͽ��ϱ�? ������ ���� ���� �˰� �����ø� 0�� �Է��ϼ���.");
				var = sc.nextInt();
				if (var == 0) {
					System.out.println("�������� Ư�� ������ ������, ū���� �˷��ִ� ���񽺸� �����ϰ� �ֽ��ϴ�.");
					inequality(0);
				} else {
					System.out.println(var + "�� ���� �� ������ ���� �˰� �ͽ��ϱ�?");
					System.out.println("(1)Ǯ�� ������ ��ȣ (2)Ǯ�� �������� ������ ���� (3)Ǯ�� ������ �� �� ������ ������ (4)Ư�� ����");
					x = sc.nextInt();
					VariableService(x,var);
				}
				break;

			default:
				System.out.println("�ٽ� �Է��ϼ���");
				break;
			}
		}
		sc.close();
	} //End InvestService

	/*
	 * ���� Ư�� ������ ���� ��� �� ����Ǵ� �޼ҵ�
	 */
	public static void ProblemService(int x, int var) {
		var-=1; //����� ù ĭ�� 0�̱� ������ �����������
		switch (x) {
		case 1:
			System.out.println(mat.getElement(var, 1));// �ɸ� �ð� ��ȯ
			break;
		case 2:
			System.out.println(mat.getElement(var, 0)==0 ? "Ǯ���� �ʾҽ��ϴ�" : "Ǯ�Ƚ��ϴ�");// Ǯ�ȴ��� ���� ��ȯ
			break;
		case 3:
			System.out.println(mat.getElement(var, 0));// ������ �����İ� ��ȯ
			break;
		case 4:
			int y = 2;// 2���� 3001���� ��µǰ�
			while (y <= 3001) {
				if(mat.getElement(var, y)>=0) {
					System.out.println("x"+(y-1)+"������ ������ : "+mat.getElement(var, y));
				}
				y++;
			}
			System.out.println("������ �������� ������ �ʾҽ��ϴ�.");
			// ������ ������ ����
			break;
		case 5:
			int i = 0;
			double sum = 0;
			while (i < 100)//resultsample�� ���� ������ 100�� ���
				{
				sum = sum + mat.getElement(i, 1);
				i++;
			}
			System.out.println(sum / 100);// ��� �ɸ� �ð�, 
			break;
		default:
			System.out.println("�ٽ��Է��ϼ���");
			break;

		}
	}//end ProblemService

	/*
	 * ���� �������� ������ Ư�� ������ ���� ��� �� ����Ǵ� �޼ҵ�
	 */
	public static void VariableService(int x, int var) {
		switch (x) {
		case 1:
			String result = "";
			for (int i = 0; i < mat.getNumberOfRows(); i++) {
				if (mat.getElement(i, var + 1) >= 0) {
					if (mat.getElement(i, 0) != 0) {
						result += (i+1) + "\n";
					}
				}
			}
			System.out.println("�� ������ ���� ������ �� ");
			System.out.println(result + " �� ° �������� Ǯ�Ƚ��ϴ�.");
			// ������ ���� ������ �� Ǯ�� ������ ��ȯ
			break;
		case 2:
			String result1 = "";
			Double max=0.0;
			Double avg=0.0;
			int count=0;
			for (int i = 0; i < mat.getNumberOfRows(); i++) {
				if (mat.getElement(i, var + 1) >= 0) {
					if (mat.getElement(i, 0) != 0) {
						result1 += (i+1) + "��° ���� ������ : " + mat.getElement(i, 0) + "\n";
						if(mat.getElement(i, 0)>max) {
							max=mat.getElement(i, 0);
						}
						avg+=mat.getElement(i, 0);
						count++;
					}
				}
			}
			System.out.println("Ǯ�� �������� ���������� ������ �����ϴ�.");
			System.out.println(result1);
			System.out.println("������ ��� : " + (avg/count)+" ������ �ִ�ġ : "+max);
			// Ǯ�� �������� ������ ����
			break;
		case 3:
			String result2 = "";
			for (int i = 0; i < mat.getNumberOfRows(); i++) {
				if (mat.getElement(i, var + 1) >= 0) {
					if (mat.getElement(i, 0) != 0) {
						result2 += (i+1) + "��° �������� �� ������ ������ : " + mat.getElement(i, var + 1) + "\n";
					}
				}
			}
			System.out.println("Ǯ�� ������ �� �� ������ �����ش� ������ �����ϴ�.");
			System.out.println(result2);
			break;
			// Ǯ�� ������ �� �� ������ ������
		case 4:
			System.out.println("�������� �� ������ Ư�� ������ ������, ū���� �˷��ִ� ���񽺸� �����ϰ� �ֽ��ϴ�.");
			inequality(var);
			break;

		default:
			System.out.println("�ٽ� �Է��ϼ���");
			break;
		}
	}//end varianceService

	/*
	 * Ư�� ������ ũ�ų� ���� ������ ��� ��ȯ�ϴ� �޼ҵ�
	 */
	private static void inequality(int var) {
		Scanner sc = new Scanner(System.in);
		if(var==0) {
			var-=1; //�ڿ� var + 1 �۾��� ���ֱ� ������ �������� ���Ϸ��� var�� -1�� �������־����.
		}

		System.out.println("Ư�� ���� �Է��ϼ���.");
		double point = sc.nextDouble();
		String sign;
		String result3 = "";
		while (true) {
			System.out.println("�� �� �̻��� ������ ���ϸ� >, ������ ������ ���ϸ� <�� �Է��ϼ���");
			sign = sc.next();
			if (sign.equals("<")) {
				for (int i = 0; i < mat.getNumberOfRows(); i++) {
					if (mat.getElement(i, var + 1) <= point) {
						if (mat.getElement(i, 0) != 0) {
							result3 += (i+1) + "��° �������� ���ǿ� �´� �� ������ ������ : " + mat.getElement(i, var + 1) + "\n";
						}
					}
				}
				break;
			} else if (sign.equals(">")) {
				for (int i = 0; i < mat.getNumberOfRows(); i++) {
					if (mat.getElement(i, var + 1) >= point) {
						if (mat.getElement(i, 0) != 0) {
							result3 += (i+1) + "��° �������� ���ǿ� �´� �� ������ ������ : " + mat.getElement(i, var + 1) + "\n";
						}
					}
				}
				break;
			} else {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
		System.out.println("���ǿ� �´� ������ �����ص��� ������ �����ϴ�.");
		System.out.println(result3);
		sc.close();
	}// end inequality

	public static void main(String[] args) {
		InvestService is = new InvestService(); //�����ڸ� �����ϸ� ���񽺰� ���۵ȴ�.

	}
}
