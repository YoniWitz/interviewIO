package specialTricks;

public class SpecialTricks4Second {
	static int findPeak(int[] a) {
		if (a == null)
			return -1;
		if (a.length == 1 || a[0] > a[1])
			return 0;
		if (a[a.length - 1] > a[a.length - 2]) {
			return a.length - 1;
		}
		int start = 0;
		int end = a.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (a[mid] > a[mid - 1]) {
				if (a[mid] > a[mid + 1])
					return mid;
				else
					end = mid - 1;
			} else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 8 };
		System.out.println(findPeak(arr));
	}
}
