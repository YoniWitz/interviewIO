package intro;

import java.util.Stack;

public class Intro1First {

	public static void main(String[] args) {
		Stack<Integer> myStack = new Stack<>();
		myStack.push(1);
		myStack.push(4);
		System.out.println(search(myStack, 1));
		System.out.println(search(myStack, 4));
		System.out.println(search(myStack, 4));
	}

	public static boolean search(Stack<Integer> myStack, int toFind) {
		Stack<Integer> tempStack = new Stack<>();
		while (!myStack.isEmpty()) {
			if (myStack.peek() == toFind) {
				while (!tempStack.isEmpty()) {
					myStack.push(tempStack.pop());
				}
				return true;
			}

			tempStack.push(myStack.pop());
		}
		while (!tempStack.isEmpty()) {
			myStack.push(tempStack.pop());
		}
		return false;
	}
}
