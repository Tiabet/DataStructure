/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS1009;

import java.io.*;
import java.util.*;

public class EvaluateArith2 {

	public double infix(String expression) {
		// remove white space and add evaluation operator
		expression = expression.replaceAll("[\t\n ]", "") + "=";
		String operator = "*/+-=";
		// split up the operators from the values
		StringTokenizer tokenizer = new StringTokenizer(expression, operator, true);
		Stack operatorStack = new java.util.Stack();
		Stack valueStack = new Stack();
		while (tokenizer.hasMoreTokens()) {
			// add the next token to the proper stack
			String token = tokenizer.nextToken();
			System.out.println("token:" + token);
			if (operator.indexOf(token) < 0) {
				valueStack.push(token);
			} else {
				operatorStack.push(token);
			}
			// perform any pending operations
			resolve(valueStack, operatorStack);// 다 넣고 푸는 게 아니라 넣으면서 푸는 거임, 토큰 하나 넣고 풀고 하나 넣고 푸는 식
		}
		// return the top of the value stack
		String lastOne = (String) valueStack.pop();
		return Double.parseDouble(lastOne);
	}

	public int getPriority(String op) {
		if (op.equals("*") || op.equals("/")) {
			return 1;
		} else if (op.equals("+") || op.equals("-")) {
			return 2;
		} else if (op.equals("=")) {
			return 3;
		} else {
			return Integer.MIN_VALUE;
		}
	}

	public void resolve(Stack values, Stack operators) {
		while (operators.size() >= 2) { // 연산자가 2개 들어온 순간부터 바로 풀이 진행, 다 넣고 푸는 게 아님
			String later = (String) operators.pop();
			String prev = (String) operators.pop();
			System.out.println("later:" + later + ",prev:" + prev);
			System.out.println("getPriority(later):" + getPriority(later) + ",getPriority(prev):" + getPriority(prev));

			if (getPriority(later) < getPriority(prev)) {
				operators.push(prev);
				operators.push(later); // 우선도가 작은 작업 먼저 실행되는 알고리즘
				return;// 우선도가 확실해질때, 즉 1회 (value까지 합하면 2회) 계산을 미룬다. 1회인 이유는 어차피 곱셈,나눗셈이 최우선이기 때문
			} else {
				String laterValue = (String) values.pop();
				String prevValue = (String) values.pop();
				System.out.println("laterValue:" + laterValue + ",prevValue:" + prevValue);

				values.push(getResults(prevValue, prev, laterValue));// 계산한 결과를 value에 또 푸쉬
				operators.push(later);// prev를 사용했으므로 later는 다시 operators에 푸쉬
			}
		}
	}

	public String getResults(String operand1, String operator, String operand2) {
		System.out.println("Performing " + operand1 + operator + operand2);
		double op1 = Double.parseDouble(operand1);
		double op2 = Double.parseDouble(operand2);
		if (operator.equals("*")) {
			return "" + (op1 * op2);
		} else if (operator.equals("/")) {
			return "" + (op1 / op2);
		} else if (operator.equals("+")) {
			return "" + (op1 + op2);
		} else if (operator.equals("-")) {
			return "" + (op1 - op2);
		} else {
			return null;
		}
	}

	public String InfixtoPostfix(String expression) {
		String str = "";
		expression = expression.replaceAll("[\t\n ]", "") + "=";
		String operator = "*/+-=";
		StringTokenizer tokenizer = new StringTokenizer(expression, operator, true);
		Stack operatorStack = new java.util.Stack();

		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			System.out.println("token:" + token);
			if (operator.indexOf(token) < 0) {
				str += token;
			} else {
				if (operatorStack.isEmpty()) {// stack이 비어있으면 연산자 push
					operatorStack.push(token);
				} else if (getPriority((String) operatorStack.peek()) > getPriority(token)) {// token이 peek보다 우선이면
					operatorStack.push(token);
				} else {
					while (!operatorStack.isEmpty()) {
						str += (String) operatorStack.pop();
						if (operatorStack.isEmpty()
								|| getPriority((String) operatorStack.peek()) > getPriority(token)) {
							break;
						}
					}
					operatorStack.push(token);
				}
			}

		}

		return str;

	}
	
	public double postfix(String expression) {
		// remove white space and add evaluation operator
				expression = expression.replaceAll("[\t\n ]", "") + "=";
				String operator = "*/+-=";
				// split up the operators from the values
				StringTokenizer tokenizer = new StringTokenizer(expression, operator, true);
				Stack operatorStack = new java.util.Stack();
				Stack valueStack = new Stack();
				while (tokenizer.hasMoreTokens()) {
					// add the next token to the proper stack
					String token = tokenizer.nextToken();
					System.out.println("token:" + token);
					
					if (operator.indexOf(token) < 0) {
						String[] longvalue = null;
						if(token.length()>1) {
							System.out.println("Token desparate");
							longvalue=token.split("");
							for(String s : longvalue) {
								valueStack.push(s);
								System.out.println("token:" + s);
								}
						}else {
						valueStack.push(token);
						}
					} else {
						operatorStack.push(token);
					}
					// perform any pending operations
					resolve2(valueStack, operatorStack);// 다 넣고 푸는 게 아니라 넣으면서 푸는 거임, 토큰 하나 넣고 풀고 하나 넣고 푸는 식
				}
				// return the top of the value stack
				String lastOne = (String) valueStack.pop();
				return Double.parseDouble(lastOne);
	}

	private void resolve2(Stack valueStack, Stack operatorStack) {
		if(valueStack.size()>=2) {
		if(!operatorStack.isEmpty()) {
			String latervalue=(String)valueStack.pop();
			String prevvalue=(String)valueStack.pop();
			String operator = (String)operatorStack.pop();
			valueStack.push(getResults(prevvalue, operator, latervalue));
		}
		}
	}

	public static void main(String[] args) {
		EvaluateArith2 fix = new EvaluateArith2();
		// String expression="4-4*4/7+5";
		String expression = "4+1-3*5+7";// ->postfix
		// System.out.println("The expression is " + expression);
		// System.out.println("evaluation is " + fix.infix(expression));
		String postfixexpression = fix.InfixtoPostfix(expression);
		System.out.println(postfixexpression);
		System.out.println(fix.postfix(postfixexpression));

		
		
	}
}
