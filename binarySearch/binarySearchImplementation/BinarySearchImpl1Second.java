package binarySearchImplementation;

public class BinarySearchImpl1Second {
	static boolean binarysearchImpl(int[] a, int x) {
		if (a == null)
			return false;

		int start = 0;
		int end = a.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (a[mid] == x) {
				return true;
			}
			if (a[mid] < x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8 };
		System.out.println(binarysearchImpl(a, 8));
	}
}
