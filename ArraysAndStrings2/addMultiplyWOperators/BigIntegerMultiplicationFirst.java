package addMultiplyWOperators;

import java.util.Arrays;

public class BigIntegerMultiplicationFirst {

	public static void main(String[] args) {
		int[] x = new int[] { 9,9,9};
		int[] y = new int[] { 9,9,9 };
		System.out.println(Arrays.toString(arraysMultiplication(x, y)));

	}

	// x=[9], y=[3,2,4] => answer = [2,9,1,6]
	// create returnarray and temp array. keep adding one to the other every
	// iteration
	public static int[] arraysMultiplication(int[] x, int[] y) {
		if (x == null || y == null)
			return null;

		int[] returnArray = new int[2];
		int[] tempArray;
		int minLength = Math.min(x.length, y.length);
		int maxLength = Math.max(x.length, y.length);

		int num = 0;

		for (int i = 0; i < minLength; i++) {
			for (int j = 0; j < maxLength; j++) {
				if (x.length < y.length) {
					num = x[x.length - 1 - i] * y[y.length - 1 - j];
				} else {
					num = y[y.length - 1 - i] * x[x.length - 1 - j];
				}

				tempArray = new int[j + i + 2];
				tempArray[0] = num / 10;
				tempArray[1] = num % 10;
				returnArray = BigIntegerAdditionFirst.arraysAddition(returnArray, tempArray);
			}
		}

		//consider removing zeros
		return returnArray;
	}
}
