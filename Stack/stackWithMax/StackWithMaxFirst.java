package stackWithMax;

import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;

public class StackWithMaxFirst {
	Stack<SimpleEntry<Integer, Integer>> myStack;

	public StackWithMaxFirst() {
		myStack = new Stack<>();
	}

	public void insert(Integer el) {
		if (myStack.isEmpty()) {
			myStack.push(new SimpleEntry<>(el, el));
		} else {
			SimpleEntry<Integer, Integer> prevEl = myStack.peek();
			if (el >= prevEl.getValue()) {
				myStack.push(new SimpleEntry<>(el, el));
			} else {
				myStack.push(new SimpleEntry<>(el, prevEl.getValue()));
			}
		}
	}

	public Integer max() throws Exception {
		if (myStack.isEmpty()) {
			throw new Exception("No more elements in stack");
		} else {
			return myStack.peek().getValue();
		}
	}

	public SimpleEntry<Integer, Integer> remove() throws Exception {
		if (myStack.isEmpty()) {
			throw new Exception("No more elements in stack");
		} else {
			return myStack.pop();
		}
	}
}
