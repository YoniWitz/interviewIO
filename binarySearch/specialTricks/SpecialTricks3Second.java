package specialTricks;

public class SpecialTricks3Second {
	static int floorSqrt(int x) {
		if (x < 0) {
			return -1;
		}
		int start = 0;
		int end = x;
		int mid;
		int closest = 0;
		int sq;
		while (start <= end) {
			mid = start + (end - start) / 2;
			sq = mid * mid;
			if (sq == x)
				return mid;
			else if (sq > x)
				end = mid - 1;
			else if (sq < x) {
				start = mid + 1;
				if (mid > closest) {
					closest = mid;
				}
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		System.out.println(floorSqrt(348));
	}
}
