package hw0104;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heaps1 {
	static int[] Smallests(int[] a, int n) {
		if (a == null || n > a.length || n == 0) {
			return null;
		}
		int[] smallest = new int[n];
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			if (i < n) {
				heap.add(a[i]);
			} else {
				if (a[i] < heap.peek()) {
					heap.remove();
					heap.add(a[i]);
				}
			}
		}

		int i = 0;
		for (Integer el : heap) {
			smallest[i++] = el;
		}
		return smallest;
	}

	public static void main(String[] args) {
		int a[] = Smallests(new int[] { 1, 3, 4, 7, 6, 92, 1, 2 }, 3);
		for (int el : a)
			System.out.println(el);
	}
}
