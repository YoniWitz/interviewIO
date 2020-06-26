package specialTricks;

public class SpecialTricks3First {
	static int findSquareRoot(int x) {
		int start = 0;
		int end = x;
		int mid;
		int midSq;

		if (x == 0) {
			return 0;
		}

		while (start <= end) {
			mid = start + (end - start) / 2;
			midSq = mid * mid;
			if (midSq == x || (midSq < x && (mid + 1) * (mid + 1) > x)) {
				return mid;
			} else {
				if (midSq > x) {
					end = mid - 1;
				}
				if (midSq < x) {
					start = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findSquareRoot(3));
	}
}
