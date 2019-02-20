package permutationsUsingAuxiliaryBuffer;

public class PrintArraySubsetsFirst {
	static void printArraySubsets(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int[] auxBuffer = new int[a.length];

		printArraySubsetsHelper(a, auxBuffer, 0, 0);
	}

	static void printArraySubsetsHelper(int[] a, int[] auxBuffer, int aIndex, int bufferIndex) {
		printBuffer(auxBuffer, bufferIndex);
		if (bufferIndex == auxBuffer.length) {
			return;
		}

		for (int i = aIndex; i < a.length; i++) {
			auxBuffer[bufferIndex] = a[i];
			printArraySubsetsHelper(a, auxBuffer, i + 1, bufferIndex + 1);
		}
	}

///////////////
	private static void printBuffer(int[] auxBuffer, int bufferIndex) {
		for (int i = 0; i < bufferIndex; i++) {
			System.out.print(auxBuffer[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		printArraySubsets(a);
	}
}
