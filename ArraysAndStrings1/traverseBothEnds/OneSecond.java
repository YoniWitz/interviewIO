package traverseBothEnds;

public class OneSecond {
	static <T> void reverseArray(T[] a) {
		if (a == null || a.length < 2) {
			return;
		}
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			swap(a, start++, end--);
		}
	}

	static private <T> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		Integer[] a = { 2, 3, 1, 0, 4 };
		reverseArray(a);
		for (int el : a) {
			System.out.print(el + " ");
		}

	}
}
