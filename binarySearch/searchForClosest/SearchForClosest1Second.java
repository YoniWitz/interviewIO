package searchForClosest;

public class SearchForClosest1Second {
	static int findClosest(int[] A, int x) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		int mid;
		int closest = A[0];
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (Math.abs(closest - x) > Math.abs(A[mid] - x))
				closest = A[mid];
			if (x == A[mid])
				return mid;
			if (x > A[mid])
				start = mid + 1;
			if (x < A[mid])
				end = mid - 1;
		}
		return closest;
	}

	public static void main(String[] args) {
		System.out.println(findClosest(new int[] { 2, 4, 6, 8 }, 1));
	}
}
