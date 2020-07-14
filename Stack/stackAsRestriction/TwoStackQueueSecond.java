package stackAsRestriction;

import java.util.Stack;

public class TwoStackQueueSecond {
	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public TwoStackQueueSecond() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void push(int item) {
		s1.push(item);
	}

	public Integer pop() {
		if (s2.isEmpty()) {
			flush();
		}
		if (s2.isEmpty())
			return null;
		return s2.pop();
	}

	public Integer peek() {
		if (s2.isEmpty()) {
			flush();
		}
		if (s2.isEmpty())
			return null;
		return s2.peek();
	}

	private void flush() {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}

	public static void main(String[] str) {
		TwoStackQueueSecond myQueue = new TwoStackQueueSecond();
		myQueue.push(1);
		myQueue.push(2);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		myQueue.push(3);
		System.out.println(myQueue.peek());
	}
}
