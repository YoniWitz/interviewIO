package specialTricks;

public class SpecialTricks4First {
	static int findPeak(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (array.length == 1 || array[0] > array[1]) {
			return 0;
		}
		if (array[array.length - 1] > array[array.length - 2]) {
			return array.length - 1;
		}
		int start = 0;
		int end = array.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (array[mid] > array[mid - 1]) {
				if (array[mid] > array[mid + 1]) {
					return mid;
				} else {
					start = mid + 1;
				}
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findPeak(new int[] { 1, 6, 4, 3 }));
	}
}
