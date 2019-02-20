package permutationsUsingAuxiliaryBuffer;

public class OneFirst {
	static void printComb(int[] a, int x) {
		if (a == null || x > a.length || a.length == 0) {
			return;
		}

		int[] auxBuffer = new int[x];

		printCombHelper(a, auxBuffer, 0, 0);
	}

	static void printCombHelper(int[] a, int[] auxBuffer, int aIndex, int bufferIndex) {
		if (bufferIndex == auxBuffer.length) {
			printBuffer(auxBuffer);
			return;
		}
		if (aIndex == a.length)
			return;

		for (int i = aIndex; i < a.length; i++) {
			auxBuffer[bufferIndex] = a[i];
			printCombHelper(a, auxBuffer, i + 1, bufferIndex + 1);
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
		printComb(a, 3);
	}

}
