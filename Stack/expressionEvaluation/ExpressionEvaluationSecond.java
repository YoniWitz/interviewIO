package expressionEvaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionEvaluationSecond {
	static int postfixEvaluation(char[] postfix) {
		if (postfix == null || postfix.length == 0) {
			return 0;
		}
		Stack<Integer> operands = new Stack<>();
		for (char ch : postfix) {
			if (ch >= '0' && ch <= '9') {
				operands.push(Character.getNumericValue(ch));
			} else {
				operate(ch, operands);
			}
		}
		return operands.pop();
	}

	static int infixEvaluation(char[] infix) {
		if (infix == null || infix.length == 0)
			return 0;

		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		Map<Character, Integer> precedence = fillPrecedence();

		for (char ch : infix) {
			if (ch >= '0' && ch <= '9') {
				operands.push(Character.getNumericValue(ch));
			} else {
				if (operators.isEmpty()) {
					operators.push(ch);
				} else {
					while (!operators.isEmpty() && (precedence.get(operators.peek()) >= precedence.get(ch))) {
						operate(operators.pop(), operands);
					}
					operators.push(ch);
				}
			}
		}

		while (!operators.isEmpty()) {
			operate(operators.pop(), operands);
		}

		return operands.pop();
	}

	private static Map<Character, Integer> fillPrecedence() {
		Map<Character, Integer> precedence = new HashMap<>();
		precedence.put('/', 2);
		precedence.put('*', 2);
		precedence.put('+', 1);
		precedence.put('-', 1);
		return precedence;
	}

	private static void operate(char ch, Stack<Integer> operands) {
		int right = operands.pop();
		int left = operands.pop();

		switch (ch) {
		case '/':
			operands.push(left / right);
			break;
		case '*':
			operands.push(left * right);
			break;
		case '+':
			operands.push(left + right);
			break;
		case '-':
			operands.push(left - right);
			break;
		}
	}

	public static void main(String[] str) {
		char[] postfix = { '1', '2', '+', '3', '*', '5', '-', '2', '/' };
		System.out.println(postfixEvaluation(postfix));
		char[] infix = { '1', '+', '3', '*', '5', '-', '2', '/', '2' };
		System.out.println(infixEvaluation(infix));
	}
}
