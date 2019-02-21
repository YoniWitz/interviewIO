package stackWithMax;

import java.util.Stack;

public class StackWithMaxSecond {
	private Stack<Integer> stack;
	private Stack<Integer> max;

	public StackWithMaxSecond() {
		stack = new Stack<>();
		max = new Stack<>();
	}

	public void push(int item) {
		stack.push(item);
		if (max.isEmpty() || item >= max.peek()) {
			max.push(item);
		}
	}

	public Integer pop() {
		if (!max.isEmpty() && max.peek() == stack.peek()) {
			max.pop();
		}
		return stack.pop();
	}

	public Integer max() {
		return max.peek();
	}

	public Integer peek() {
		return stack.peek();
	}

	public static void main(String[] args) {
		StackWithMaxSecond myStack = new StackWithMaxSecond();
		myStack.push(1);
		System.out.println(myStack.max());
		myStack.push(5);
		System.out.println(myStack.max());
		myStack.push(4);
		System.out.println(myStack.max());
		myStack.push(8);
		System.out.println(myStack.max());
		myStack.push(8);
		System.out.println(myStack.max());
		myStack.pop();
		System.out.println(myStack.max());
		myStack.pop();
		System.out.println(myStack.max());
		myStack.pop();
		System.out.println(myStack.max());
	}

}
