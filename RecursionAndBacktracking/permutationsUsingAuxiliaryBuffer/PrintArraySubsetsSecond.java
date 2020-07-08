package permutationsUsingAuxiliaryBuffer;

import java.util.Arrays;

public class PrintArraySubsetsSecond {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };

		printArrayCombinations(a);
	}

	private static void printArrayCombinations(int[] a) {
		if (a == null || a.length == 0)
			return;

		int[] buffer = new int[a.length];
		int bufferIndex = 0;
		int startIndex = 0;
		printArrayCombinationsHelper(a, buffer, startIndex, bufferIndex);
	}

	public static void printArrayCombinationsHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(buffer, 0, bufferIndex)));
		// if buffer is full
		if (startIndex == a.length) {
			return;
		}

		for (int i = startIndex; i < a.length; i++) {

			buffer[bufferIndex] = a[i];
			printArrayCombinationsHelper(a, buffer, i + 1, bufferIndex + 1);
		}
	}
}
