package reverseTraversal;

public class TraversingArrayInreverse1First {
	static void doubleEvens(int[] a) {
		int arrayEnd = a.length - 1;
		if (a == null || arrayEnd < 1) {
		} else {
			int numbersEnd = findWhereNumbersEnd(a);
			while (numbersEnd >= 0) {
				if (a[numbersEnd] % 2 == 0) {
					a[arrayEnd--] = a[numbersEnd];
				}
				a[arrayEnd--] = a[numbersEnd--];
			}

		}
		for (int el : a) {
			System.out.println(el);
		}

	}

	private static int findWhereNumbersEnd(int[] a) {
		int i = 0;
		while (i < a.length - 1 && a[i] != -1)
			i++;
		return i - 1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 2, 2, 3, 3, -1, -1, -1 };
		doubleEvens(a);
	}
}
