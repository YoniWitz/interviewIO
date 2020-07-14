package expressionEvaluation;

import java.util.Stack;

public class ExpressionEvaluation1N2First {

	public static void main(String[] str) {
		evaluatePostFix(new String[] { "1", "7", "+", "2", "-" });
		evaluateInfix(new String[] { "1", "+", "2", "/", "1", "-", "3", "*", "2" });
	}

	public static void evaluatePostFix(String[] postfixExpression) {
		if (postfixExpression == null)
			return;

		Stack<Integer> myStack = new Stack<>();
		int left;
		int right;

		for (String str : postfixExpression) {
			try {
				if (str == "+") {
					right = myStack.pop();
					left = myStack.pop();
					myStack.push(left + right);
				} else if (str == "-") {
					right = myStack.pop();
					left = myStack.pop();
					myStack.push(left - right);
				} else {
					try {
						myStack.push(Integer.parseInt(str));
					} catch (Exception e) {
						System.out.println(e.getMessage());
						return;
					}
				}
			} catch (Exception e) {
				System.out.println("go fix yourself");
				return;
			}
		}

		System.out.println(myStack.peek());
	}

	public static void evaluateInfix(String[] infixExpression) {
		if (infixExpression == null)
			return;

		String prec1 = "+-";
		String prec2 = "*/";

		Stack<Integer> operandStack = new Stack<>();
		Stack<String> operatorStack = new Stack<>();

		for (String str : infixExpression) {
			// if operator is empty, just shove it in
			if (operatorStack.isEmpty() && (prec2.contains(str) || prec1.contains(str))) {
				operatorStack.push(str);
			} else {
				// * or /
				if (prec2.contains(str)) {
					while (prec2.contains(operatorStack.peek()) && !operatorStack.isEmpty()) {
						process(operatorStack, operandStack);
					}
					operatorStack.push(str);
					// + or -
				} else if (prec1.contains(str)) {
					while (!operatorStack.isEmpty()) {
						process(operatorStack, operandStack);
					}
					operatorStack.push(str);
					// number
				} else {
					operandStack.push(Integer.parseInt(str));
				}
			}
		}
		while (!operatorStack.isEmpty()) {
			process(operatorStack, operandStack);
		}
		System.out.println(operandStack.pop());
	}

	public static void process(Stack<String> operatorStack, Stack<Integer> operandStack) {
		int right = operandStack.pop();
		int left = operandStack.pop();

		try {
			switch (operatorStack.pop()) {
			case ("+"):
				operandStack.push(right + left);
				break;
			case ("-"):
				operandStack.push(left - right);
				break;
			case ("*"):
				operandStack.push(left * right);
				break;
			case ("/"):
				operandStack.push(left / right);
				break;
			default:
				throw new Exception("Something's wrong");
			}
		} catch (Exception e) {
			System.out.println("something is wrong");
			return;
		}
	}
}
