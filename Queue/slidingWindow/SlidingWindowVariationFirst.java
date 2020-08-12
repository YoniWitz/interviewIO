package slidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowVariationFirst {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumSlidingWindow(new int[] { 2, 3, 5, 6, 2, 1 }, 3)));
	}

	public static int[] sumSlidingWindow(int[] array, int K) {
		if (array == null || K == 0 || array.length == 0 || array.length < K)
			return null;

		Queue<Integer> myQueue = new LinkedList<>();

		int[] returnArray = new int[array.length - K + 1];
		int index = 0;

		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			myQueue.add(array[i]);
			sum += array[i];

			if (i == K - 1) {
				returnArray[index++] = sum;
			}
			if (i > K - 1) {
				sum -= myQueue.remove();
				returnArray[index++] = sum;
			}
		}
		return returnArray;
	}
}
