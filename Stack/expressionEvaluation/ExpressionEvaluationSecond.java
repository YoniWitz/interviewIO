package expressionEvaluation;

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
		char[] postfix = { '1', '2', '+', '3', '*' };
		System.out.println(postfixEvaluation(postfix));
	}
}
