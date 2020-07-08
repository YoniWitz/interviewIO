package permutationsUsingAuxiliaryBuffer;

public class PrintArrayPermutationsFirst {
	static void printPerm(int[] a, int x) {
		if (a == null || x > a.length || a.length == 0) {
			return;
		}

		int[] auxBuffer = new int[x];
		boolean[] isInBuffer = new boolean[a.length];

		printPermHelper(a, auxBuffer, 0, isInBuffer);
	}

	static void printPermHelper(int[] a, int[] auxBuffer, int bufferIndex, boolean[] isInBuffer) {
		if (bufferIndex == auxBuffer.length) {
			printBuffer(auxBuffer);
			return;
		}

		for (int i = 0; i < a.length; i++) {
			if (!isInBuffer[i]) {
				auxBuffer[bufferIndex] = a[i];
				isInBuffer[i] = true;
				printPermHelper(a, auxBuffer, bufferIndex + 1, isInBuffer);
				isInBuffer[i] = false;
			}
		}
	}

///////////////
	private static void printBuffer(int[] auxBuffer) {
		for (int el : auxBuffer) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		printPerm(a, 3);
	}

}
