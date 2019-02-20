package binarySearchWithDups;

public class BinarySearchWithDups1First {
	static int binarySearchWithDups(int[] A, int x) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (x < A[mid] || (mid > 0 && x == A[mid] && x == A[mid - 1])) {
				end = mid - 1;
				continue;
			}
			if (x > A[mid])
				start = mid + 1;

			if (x == A[mid])
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearchWithDups(new int[] { 2, 2, 3 }, 2));
	}
}
