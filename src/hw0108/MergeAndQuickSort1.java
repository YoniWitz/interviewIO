package hw0108;

public class MergeAndQuickSort1 {

	static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		if (a == null || b == null) {
			return null;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		int[] merged = new int[a.length + b.length];

		while (i < a.length && j < b.length) {
			merged[k++] = a[i] < b[j] ? a[i++] : b[j++];
		}

		for (; i < a.length; i++) {
			merged[k++] = a[i];
		}
		for (; j < b.length; j++) {
			merged[k++] = b[j];
		}

		return merged;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 7 };
		int[] b = { 3, 4, 5 };
		int[] c = mergeTwoSortedArrays(a, b);
		for (int el : c) {
			System.out.println(el);
		}
	}

}
