package specialTricks;

public class SpecialTricks2First {

	public static void main(String[] args) {
		binarySearchUnkownLength(new int[] { 1, 3, 5, 6 }, 3);

	}

	private static void binarySearchUnkownLength(int[] is, int i) {
		if (is == null)
			return;
		int length = findLength(is);
		System.out.println(length);
		// perform binary search from here

	}

	// to find array length:
	// while till exception: if no exception, double the index. if exception,
	// end of array will be between index and index - 1.
	// perform binary search to search for end of array: if exception, mid = mid-1.
	// else return
	// that index.
	private static int findLength(int[] is) {
		boolean exc = false;
		int a;
		int pow = 0;
		int index = 0;

		// find first index that throws an error with jumps of two
		try {
			index = (int) Math.pow(2, pow);
			while (!exc) {
				index = (int) Math.pow(2, pow);
				a = is[index];

				pow++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			exc = !exc;
		}

		// length is where mid is in bounds and one to the right is out of bounds
		// say index was 4 when exception occurred, so now perform binary search between
		// 2 (2pow1) and (2pow2) 4
		int first = (int) Math.pow(2, pow - 1);
		int last = index;
		int mid = 0;
		while (first <= last) {
			mid = first + (last - first) / 2;
			try {
				a = is[mid];
			}
			// if mid is out of bounds, look to the left
			catch (Exception e) {
				last = mid - 1;
				continue;
			}
			try {
				// if mid is in bounds:
				a = is[mid + 1];
			}
			// if right to it is out of bounds, bingo
			catch (ArrayIndexOutOfBoundsException e) {
				return mid + 1;
			}
			// if right to it is in bounds, look to its right
			first = mid + 1;
		}
		return -1;
	}

}
