package traverseBothEnds;

public class TraversingFromBothEnds1First {

	static void reverseOrder(int[] a) {
		if (a == null || a.length < 2) {
		} else {
			int start = 0;
			int end = a.length - 1;
			while (start < end) {
				swap(a, start++, end--);
			}
		}
		for (int el : a) {
			System.out.println(el);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2 };
		reverseOrder(a);
	}
}
