package searchForClosest;

public class SearchForClosest2Second {
	static int binarySearch(int[] A, int x) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		int mid;
		int closest = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (Math.abs(A[closest] - x) > Math.abs(A[mid] - x))
				closest = mid;

			if (x > A[mid])
				start = mid + 1;
			else if (x < A[mid])
				end = mid - 1;
			else if (x == A[mid])
				return mid;
		}

		return A[closest] > x ? closest : closest + 1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 2, 4, 6, 8 }, 9));
	}
}
