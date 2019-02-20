package dutchNationalFlag;

public class DNF2Second {
	static void swapZeros(int[] a) {
		if (a == null || a.length < 2) {
			return;
		}

		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			if (a[start] == 0) {
				DutchNationalFlag1First.swap(a, start, end--);
			} else
				start++;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 0, 4, 3, 0, 5, 0 };
		swapZeros(a);
		for (int el : a) {
			System.out.print(el + " ");
		}

	}

}
