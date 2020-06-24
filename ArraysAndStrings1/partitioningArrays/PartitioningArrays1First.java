package partitioningArrays;

import java.util.Arrays;

public class PartitioningArrays1First {
	public static void main(String[] args) {
		int[] a = { 4, 2, 0, 1, 0, 3, 0 };
		int[] b = { 0, 0, 0 };
		int[] c = { 1, 2, 3 };
		rearrange(a);
		rearrange(b);
		rearrange(c);
	}

	// [0,0,0] -> [0,0,0]
	// [1,2,3] -> [1,2,3]
	// [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]

	// psuedo:
	// keep pointers to first (0) and last(n-1)
	// loop through array
	// if current number zero: promote left zero
	// if not zero: find last and.
	// promote left zero
	// end when pointers meet
	public static void rearrange(int[] array) {
		if (array == null)
			return;

		int arrayLength = array.length;
		if (arrayLength == 1 || arrayLength == 0) {
			System.out.println(Arrays.toString(array));
			return;
		}

		int zeroLeft = 0;
		int zeroRight = arrayLength - 1;

		for (int i = 0; i < arrayLength; i++) {
			if (array[i] != 0) {
				while (array[zeroRight] != 0 && zeroRight > zeroLeft)
					zeroRight--;
				if (zeroRight <= zeroLeft) {
					System.out.println(Arrays.toString(array));
					return;
				}
				array[zeroRight] = array[i];
				array[i] = 0;
			}
			zeroLeft++;
		}
		System.out.println(Arrays.toString(array));
	}
}
