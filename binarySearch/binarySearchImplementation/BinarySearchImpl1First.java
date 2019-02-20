package binarySearchImplementation;

public class BinarySearchImpl1First {
	static int binarySearch(int[] A, int x) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (x == A[mid])
				return mid;
			if (x > A[mid])
				start = mid + 1;
			if (x < A[mid])
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 2, 4, 6, 8 }, 80));
	}
}
