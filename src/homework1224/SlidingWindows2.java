package homework1224;

import java.util.AbstractMap.SimpleEntry;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SlidingWindows2 {
	Deque<SimpleEntry<Integer, Integer>> myQueue;

	public SlidingWindows2() {
		myQueue = new LinkedList<>();
	}

	public void addPrice(int price, int day) {
		myQueue.push(new SimpleEntry<>(price, day));
		while (myQueue.peekLast().getValue() < day - 2) {
			myQueue.removeLast();
		}

		findMax();
	}

	private void findMax() {
		Iterator<SimpleEntry<Integer, Integer>> iterator = myQueue.iterator();
		int max = 0;
		int current;
		while (iterator.hasNext()) {
			current = iterator.next().getKey();
			max = current > max ? current : max;
		}
		System.out.println(max);
	}
}
