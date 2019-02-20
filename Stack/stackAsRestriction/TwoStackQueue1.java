package stackAsRestriction;

import java.util.Stack;

public class TwoStackQueue1<T> {
	public Stack<T> A;
	public Stack<T> B;

	public TwoStackQueue1() {
		A = new Stack<>();
		B = new Stack<>();
	}

	public void add(T item) {
		A.push(item);
	}

	public T pop() throws Exception {
		if (B.isEmpty() && A.isEmpty()) {
			throw new Exception("no more elements in queue");
		} else if (B.isEmpty())
			moveAllFromAToB();

		return B.pop();
	}

	public T peek() throws Exception {
		if (B.isEmpty() && A.isEmpty()) {
			throw new Exception("no more elements in queue");
		} else if (B.isEmpty())
			moveAllFromAToB();

		return B.peek();
	}

	private void moveAllFromAToB() {
		while (!A.isEmpty()) {
			B.push(A.pop());
		}
	}

	public static void main(String[] args) throws Exception {
		TwoStackQueue1<Integer> myQueue = new TwoStackQueue1<>();

		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		System.out.println(myQueue.pop());
		myQueue.add(5);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());

		myQueue.add(6);
		myQueue.add(7);
		System.out.println(myQueue.peek());
		System.out.println(myQueue.peek());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.peek());
	}
}
