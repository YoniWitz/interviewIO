package homework1224;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingDoors {
	public static void sum(int[] array, int K) {
		if (array == null || K == 0 || array.length == 0 || array.length < K) {
			return;
		} else {
			Deque<Integer> myDeque = new LinkedList<>();
			int sum = 0;
			for (int i = 0; i <= array.length - 1; i++) {
				myDeque.push(array[i]);
				sum += array[i];
				if (myDeque.size() >= K) {
					if (myDeque.size() > K) {
						sum -= myDeque.pollLast();
					}
					System.out.println(sum);
				}
			}
		}
	}

	public static void main(String[] args) {
		sum(new int[] { 2, 3, 5, 6, 2, 1 }, 3);

	}
}
