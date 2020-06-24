package partitioningArrays;

import java.util.Arrays;

public class PartitioningArrays2First {
	public static void main(String[] args) {
		int[] a = { 4, 2, 0, 5, 0, 3, 0 };
		int[] b = { 0, 0, 0 };
		int[] c = { 1, 2, 3 };
		int[] d = { 0 };
//		rearrange(a);
//		rearrange(b);
//		rearrange(c);
//		rearrange(d);
//		rearrange(null);
		rearrange2(a);
		rearrange2(b);
		rearrange2(c);
		rearrange2(d);
		rearrange2(null);
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
		System.out.println("fuck you");
		if (array == null)
			return;

		int arrayLength = array.length;

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

	// [0,0,0] -> [0,0,0]
	// [1,2,3] -> [1,2,3]
	// [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]

	// psuedo:
	// keep index of zero left.
	// loop through array:
	// if zero, swap with zero left, promote zero left

	public static void rearrange2(int[] array) {
		System.out.println("fuck you too");
		if (array == null)
			return;

		int arrayLength = array.length;
		int zeroCloud = 0;
		for (int i = 0; i < arrayLength; i++) {
			if (array[i] == 0) {
				array[i] = array[zeroCloud];
				array[zeroCloud++] = 0;
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
