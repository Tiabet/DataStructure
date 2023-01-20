/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW2;


/**
 *
 * @author KimJeongHyun
 */
public class MyPolynomial {

	private MyTerm first;

	private class MyTerm {
		private int exponent;
		private double coef;
		private MyTerm next;

		public MyTerm(int exp, double coef) {
			this.exponent = exp;
			this.coef = coef;
		}
	}

	public MyPolynomial(int exp, double coef) {
		first = new MyTerm(exp, coef);
	}

	public boolean add(int exp, double coef) {
		MyTerm newterm = new MyTerm(exp, coef);
		MyTerm temp = first;
		first = newterm;
		first.next = temp;
		return true;
	}

	public boolean add2(int exp, double coef) {
		MyTerm temp = first;
		boolean same = false; // stop if find same exponential.
		while (temp != null && !same) {
			if (temp.exponent == exp) {
				temp.coef += coef;
				same = !same;
			}
			temp = temp.next;
		}
		if (!same) {// if there is not same exponential, use add method.
			add(exp, coef);
			same = !same;
		}
		return same;// if add successes, return true.
	}

	public MyTerm remove(int exp) {
		MyTerm term = first;
		MyTerm result = findTerm(exp);// use findTerm method to find what is term to remove.
		if (result != null) {// if there is no corresponding term, skip this method.
			if (result == first) {
				first = first.next;
			} else {
				while (term != null) {
					if (term.next == result) {
						term.next = result.next;
					}
					term = term.next;
				}
			}
		}
		return result;
	}

	public String toString() {

		// Output in descending order of exponent

		MyTerm temp = first;
		String str = "";
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		} // to make array, check number of terms

		temp = first;// reset temp for storing terms in array

		MyTerm[] temparray = new MyTerm[size];// make array to sort polynomial

		for (int i = 0; temp != null; i++) {
			temparray[i] = temp;
			temp = temp.next;
		} // store terms in array

		for (int i = 0; i < temparray.length - 1; i++) {
			for (int j = 0; j < temparray.length - 1 - i; j++) {
				if (temparray[j].exponent < temparray[j + 1].exponent) {
					MyTerm change = temparray[j];
					temparray[j] = temparray[j + 1];
					temparray[j + 1] = change;
				}
			}
		} // sort in descending order

		for (int i = 0; i < temparray.length; i++) {
			if (i < temparray.length - 1) {
				str += temparray[i].coef + "x^(" + temparray[i].exponent + ")+";
			} else {
				str += temparray[i].coef + "x^(" + temparray[i].exponent + ")";
			}
		}

		return str;

	}

	public MyTerm findTerm(int exponent) {
		MyTerm result = null;
		boolean found = false;
		MyTerm temp = first;
		while (temp != null && !found) {
			if (temp.exponent == exponent) {
				result = temp;
				found = !found;// stop if find corresponding term.
			}
			temp = temp.next;
		}
		return result;// return null if there is no corresponding term.
	}

	public double evaluate(double x) {
		MyTerm temp = first;
		double value = 0d;
		while (temp != null) {
			value = value + temp.coef * Math.pow(x, temp.exponent);
			temp = temp.next;
		}
		return value;
	}

	public static void main(String[] args) {
		MyPolynomial pol = new MyPolynomial(2, 1d); // 1x^2
		pol.add2(1, 1); // 1x^2 + 1x^1
		pol.add2(0, 1); // 1x^2 + 1x^1 + 1
		pol.add2(1, 1); // 1x^2 + 2x^1 + 1
		System.out.println("polynomial:" + pol.toString());
		System.out.println("f(1)=" + pol.evaluate(1));
		System.out.println("f(-1)=" + pol.evaluate(-1));
		System.out.println("f(0)=" + pol.evaluate(0));
		MyTerm term = pol.remove(3);
		if (term != null) {// if there is no term to remove, skip.
			System.out.println("removed term:" + term.coef + "x^(" + term.exponent + ")");
			System.out.println("polynomial:" + pol.toString());
			System.out.println("f(1)=" + pol.evaluate(1));
			System.out.println("f(-1)=" + pol.evaluate(-1));
			System.out.println("f(0)=" + pol.evaluate(0));
		} else {
			System.out.println("no corresponding term");
		}

	}
}