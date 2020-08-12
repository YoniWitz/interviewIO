package queueWMax;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax1First {
	public static void main(String[] args) {
		QueueWithMax queueWithMax = new QueueWithMax();

		try {
			queueWithMax.add(5);
			System.out.println(queueWithMax.max());
			queueWithMax.add(6);
			System.out.println(queueWithMax.max());
			queueWithMax.add(4);
			System.out.println(queueWithMax.max());
			queueWithMax.remove();
			System.out.println(queueWithMax.max());
			queueWithMax.remove();
			System.out.println(queueWithMax.max());
			queueWithMax.remove();
			queueWithMax.remove();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class QueueWithMax {
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
			throw new Exception("Queue is empty");
		}
		if (myQueue.peek() == max.peek()) {
			max.remove();
		}
		return myQueue.poll();
	}

	public int max() throws Exception {
		if (max.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return max.peek();
	}
}
