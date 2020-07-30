package specialTricks;

import java.util.Arrays;

public class RotateArrayFirst {
	public static void main(String[] str) {
		Integer[] array = { 1, 2, 3, 4, 5, 6 };
		//reverseArray(array, 0, array.length - 1);
		rotateArray(array, 2);
		System.out.println(Arrays.toString(array));
	}

	// A = [1,2,3,4,5,6] and X = 2, Result = [5,6,1,2,3,4]
	// reverse everything
	// reverse till x - 1
	// reverse from x
	public static <T> void rotateArray(T[] array, int x) {
		if (array == null || array.length < 2)
			return;

		reverseArray(array, 0, array.length - 1);
		reverseArray(array, 0, x - 1);
		reverseArray(array, x, array.length - 1);
	}

	private static <T> void reverseArray(T[] array, int start, int end) {
		if (array == null || array.length < 2)
			return;

		while (start < end) {
			T temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
