/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS1009;

/**
 *
 * @author TEST
 */
public class EvaluateArith {
	String expr = null;

	EvaluateArith(String expression) {
		this.expr = expression;
	}

	double evaluate() {
		String[] tokens = expr.split(" ");
		StackInterface<String> ops = new ArrayStack<String>();
		StackInterface<Double> vals = new ArrayStack<Double>();

		for (int k = 0; k < tokens.length; k++) {
			String s = tokens[k].trim();
			System.out.println("s:" + s);
			if (s.equals("(")) {
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			} else if (s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else if (op.equals("/")) {
					v = vals.pop() / v;
				} else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				}
				System.out.println("push(v):" + v);
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(s));
			}
		} // ")"가 나와야만 연산을 진행하기 때문에 많이 부족한 알고리즘임

		return vals.pop();
		// return -0.0d;
	}

	void show() {
		String[] tokens = expr.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			System.out.println("token:" + tokens[i]);
		}
	}

	public static void main(String[] args) {
		EvaluateArith arith = new EvaluateArith("( ( 3 * 62 ) + sqrt ( 2 ) )");
		// arith.show();
		double value = arith.evaluate();
		System.out.println("value: " + value);
	}
}
