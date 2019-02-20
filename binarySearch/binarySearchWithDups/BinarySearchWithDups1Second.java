package binarySearchWithDups;

public class BinarySearchWithDups1Second {
	static int binarySearchWithDups(int[] A, int x) {
		if (A == null)
			return -1;
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;

			if (x > A[mid])
				start = mid + 1;
			else if (x < A[mid] || ((A[mid] == x) && (mid - 1 >= 0) && (A[mid - 1] == x)))
				end = mid - 1;
			else if (x == A[mid])
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearchWithDups(new int[] { 2, 3, 5, 5, 8, 9, 11 }, 8));
	}
}
