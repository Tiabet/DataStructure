package DS0926;

public class Polynomial {

	private MyTerm firstTerm;

	private class MyTerm {
		double coeff;
		int exp;
		MyTerm next;

		MyTerm(double coeff, int exp) {
			this.coeff = coeff;
			this.exp = exp;
		}
	}

	public Polynomial(double coeff, int exp) {
		this.firstTerm = new MyTerm(coeff, exp);
	}

	public void add(double coeff, int exp) {
		MyTerm tempTerm = new MyTerm(coeff, exp);
		tempTerm.next = firstTerm;
		firstTerm = tempTerm;
	}

	public void printout() {
		MyTerm tempTerm = firstTerm;
		while (tempTerm != null) {
			System.out.print(""+tempTerm.coeff+"x^"+tempTerm.exp+"+");
			tempTerm = tempTerm.next;
		}
		System.out.println(" ");
	}
	public void evaluate(double x) {
		double result=0;
		MyTerm tempTerm = firstTerm;
		while (tempTerm != null) {
			
			result+=tempTerm.coeff*Math.pow(x, tempTerm.exp);
			
			tempTerm = tempTerm.next;
		}
		System.out.println(result);
	}
	
	public Polynomial der() {
		Polynomial pol = new Polynomial(0,0);
		MyTerm tempTerm = firstTerm;
		while (tempTerm != null) {
			if(tempTerm.exp!=0) {
				pol.add(tempTerm.coeff*tempTerm.exp, tempTerm.exp-1);
			
			} 
			tempTerm = tempTerm.next;
		}
		return pol;
	}

	public static void main(String[] args) {
		Polynomial pol=new Polynomial(1d,70);
		pol.add(1, 0);
		pol.add(-1,1);
		
		pol.printout();
		pol.evaluate(-1);
		Polynomial pol2=pol.der();
		pol2.printout();

	}

}
