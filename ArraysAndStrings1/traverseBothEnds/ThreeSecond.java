package traverseBothEnds;

import java.util.Arrays;
import javafx.util.Pair;

public class ThreeSecond {
	static Pair<Integer, Integer> findShortestSubArray(int[] a) {
		if (a == null || a.length < 2) {
			return null;
		}
		int start = 0;
		while (a[start] <= a[start + 1])
			start++;
		int end = a.length - 1;
		while (a[end] >= a[end - 1])
			end--;

		int minValue = findMinValue(Arrays.copyOfRange(a, start, end + 1));
		int maxValue = findMaxValue(Arrays.copyOfRange(a, start, end + 1));

		for (int i = start - 1; i >= 0; i--) {
			if (a[i] > minValue) {
				start = i;
			}
		}

		for (int i = end + 1; i < a.length; i++) {
			if (a[i] < maxValue)
				end = i;
		}

		return new Pair<Integer, Integer>(start, end);
	}

	private static int findMaxValue(int[] a) {
		int max = a[0];
		for (int el : a) {
			if (el > max) {
				max = el;
			}
		}
		return max;
	}

	private static int findMinValue(int[] a) {
		int min = a[0];
		for (int el : a) {
			if (el < min) {
				min = el;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] a = { 0, 2, 5, 3, 1, 8, 6, 9 };
		Pair<Integer, Integer> myPair = findShortestSubArray(a);

		System.out.println(myPair.getKey());
		System.out.println(myPair.getValue());
	}
}
