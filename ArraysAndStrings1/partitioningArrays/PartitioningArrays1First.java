package partitioningArrays;

import java.util.Arrays;

public class PartitioningArrays1First {
	public static void main(String[] args) {
		int[] a = { 4, 2, 0, 5, 0, 3, 0 };
		int[] b = { 0, 0, 0 };
		int[] c = { 1, 2, 3 };
		int[] d = { 0 };
		rearrangeZerosToEnd(a);
		rearrangeZerosToEnd(b);
		rearrangeZerosToEnd(c);
		rearrangeZerosToEnd(d);
		rearrangeZerosToEnd(null);
	}

	// [0,0,0] -> [0,0,0]
	// [1,2,3] -> [1,2,3]
	// [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]

	// psuedo:
	// keep index of zero left.
	// loop through array:
	// if  not zero, swap with nonzero left, promote nonzero left

	public static void rearrangeZerosToEnd(int[] array) {
		if (array == null)
			return;

		int arrayLength = array.length;
		int nonZeroCloud = 0;
		for (int i = 0; i < arrayLength; i++) {
			if (array[i] != 0) {
				int temp = array[i];
				array[i] = array[nonZeroCloud];
				array[nonZeroCloud++] = temp;
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
