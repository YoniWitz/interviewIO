package queueWMax;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax1Second {

	public static void main(String[] args) {
		QueueWithMax2 queueWithMax = new QueueWithMax2();

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

		int[] A = new int[] { 4, 6, 5, 2, 4, 7 };
		int K = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(A, K)));
	}

	public static int[] maxSlidingWindow(int[] array, int K) {
		if (array == null || K < 1 || K > array.length) {
			return null;
		}

		int[] returnArray = new int[array.length - K + 1];
		QueueWithMax2 queue = new QueueWithMax2();
		int index = 0;

		for (int i = 0; i < array.length; i++) {
			queue.add(array[i]);

			if (i == K - 1) {
				returnArray[index++] = queue.max();
			}
			if (i > K - 1) {
				queue.remove();
				returnArray[index++] = queue.max();
			}
		}
		return returnArray;
	}
}

class QueueWithMax2 {
	private Queue<Integer> myQueue;
	private Deque<Integer> maxQueue;

	public QueueWithMax2() {
		myQueue = new LinkedList<>();
		maxQueue = new LinkedList<Integer>();
	}

	public void add(int toAdd) {
		myQueue.add(toAdd);
		addToMax(toAdd);
	}

	private void addToMax(int toAdd) {
		while (!maxQueue.isEmpty() && maxQueue.peekLast() < toAdd) {
			maxQueue.removeLast();
		}
		maxQueue.addLast(toAdd);
	}

	public int remove() {
		int toRemove;
		try {
			toRemove = myQueue.remove();
			removeFromMax(toRemove);
			return toRemove;
		} catch (Exception e) {
			System.out.println("queue is empty");
			return -1;
		}
	}

	public int max() {
		try {
			return maxQueue.peekFirst();
		} catch (Exception e) {
			System.out.println("this should not happen");
			return -1;
		}
	}

	private void removeFromMax(int toRemove) {
		if (maxQueue.peekFirst() == toRemove) {
			maxQueue.removeFirst();
		}
	}
}
