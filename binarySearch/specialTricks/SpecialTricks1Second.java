package specialTricks;

public class SpecialTricks1Second {
	static int binarySearchRotation(int[] A) {
		if (A == null || A.length == 0)
			return -1;

		int mid;
		int start = 0;
		int end = A.length - 1;
		int right = A[end];

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (A[mid] <= right && (mid == 0 || A[mid] < A[mid - 1])) {
				return A[mid];
			} else if (A[mid] > right) {
				start = mid + 1;
			} else if (A[mid] <= right) {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = {};
		System.out.println(binarySearchRotation(a));
	}
}
