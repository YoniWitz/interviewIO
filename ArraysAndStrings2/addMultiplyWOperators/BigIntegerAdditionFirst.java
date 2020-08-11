package addMultiplyWOperators;

import java.util.Arrays;

public class BigIntegerAdditionFirst {
	public static void main(String[] str) {
		int[] x = new int[] { 1, 9 };
		int[] y = new int[] { 3, 2, 4 };
		System.out.println(Arrays.toString(arraysAddition(x, y)));
	}

	// [1,1,1,1] + [2,2,3,3] = [3,3,4,4]
	// [9,9] + [1] = [1,0,0]
	// create returnarray bigger by one than the biggest. loop smallest array
	// backwards. add
	// % in to returnarray and keep carry for next iteration.
	// then add whatever is left from bigger array in to returnarray and keep carry
	// one time.

	public static int[] arraysAddition(int[] x, int[] y) {
		if (x == null || y == null) {
			return new int[] { -1 };
		}

		int[] returnArray = new int[Math.max(x.length, y.length) + 1];// returnArray -> [0,0,0]
		int carry = 0;
		int minLength = Math.min(x.length, y.length);
		int maxLength = Math.max(x.length, y.length);
		int num;

		// adding arrays while smaller exists
		for (int i = 0; i < minLength; i++) {
			num = carry + x[x.length - 1 - i] + y[y.length - 1 - i];
			returnArray[returnArray.length - 1 - i] = num % 10;
			carry = num / 10;
		}

		// add the rest
		for (int j = maxLength - minLength; j > 0; j--) {
			if (x.length > y.length) {
				num = (carry + x[j - 1]);
			} else {
				num = (carry + y[j - 1]);
			}
			returnArray[j] = num % 10;
			carry = num / 10;
		}
		returnArray[0] = carry;
		return returnArray;
	}
}
