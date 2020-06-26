package searchForClosest;

public class SearchForClosest1First {
	static int findClosest(int[] A, int x) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;

			if (x == A[mid])
				return mid;
			if (x > A[mid])
				start = mid + 1;
			if (x < A[mid])
				end = mid - 1;
		}

		if (A[mid] > x) {
			if (mid == 0)
				return A[0];
			if (Math.abs(A[mid] - x) < Math.abs(x - A[mid - 1]))
				return A[mid];
			else {
				return A[mid - 1];
			}
		} else {
			if (mid == A.length - 1)
				return A[A.length - 1];
			if (Math.abs(A[mid] - x) < Math.abs(x - A[mid + 1]))
				return A[mid];
			else
				return A[mid + 1];
		}
	}

	public static void main(String[] args) {
		System.out.println(findClosest(new int[] { 2, 4, 6, 8 }, 1));
		System.out.println(findClosest(new int[] { 2, 4, 6, 8 }, 9));
		System.out.println(findClosest(new int[] { 2, 4, 6, 8 }, 3));
		System.out.println(findClosest(new int[] { 2, 3, 5, 8, 9, 11 }, 7));
	}
}
