package homework1224;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax {
	private Queue<Integer> myQueue;
	private Deque<Integer> max;

	public QueueWithMax() {
		myQueue = new LinkedList<>();
		max = new LinkedList<>();
	}

	public void add(Integer element) {
		myQueue.add(element);

		while (!max.isEmpty() && max.peekLast() < element) {
			max.removeLast();
		}

		max.add(element);
	}

	public int remove() throws Exception {
		if (myQueue.isEmpty()) {
			throw new Exception();
		}
		if (myQueue.peek() == max.peek()) {
			max.remove();
		}
		return myQueue.poll();
	}

	public int max() throws Exception {
		if (max.isEmpty()) {
			throw new Exception();
		}
		return max.peek();
	}
}
