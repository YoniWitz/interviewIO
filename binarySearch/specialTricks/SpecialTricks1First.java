package specialTricks;

public class SpecialTricks1First {
	static int binarySearchRotation(int[] a) {
		if (a == null || a.length < 1) {
			return -1;
		}
		int start = 0;
		int end = a.length - 1;
		int mid;
		int right = a[end];
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (a[mid] <= right) {
				if (mid == 0 || a[mid] < a[mid - 1]) {
					return a[mid];
				} else {
					end = mid - 1;
				}
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearchRotation(new int[] { 4, 1 }));
	}
}
