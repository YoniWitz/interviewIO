package traverseBothEnds;

public class TraverseBothEndsTwoFirst {
	static int[] checkSum(int[] a, int x) {
		if (a == null || a.length < 2) {
			return (new int[] { -1, -1 });
		}
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			if (a[start] + a[end] == x) {
				return (new int[] { start, end });
			}
			if (a[start] + a[end] > x) {
				end--;
			}
			if (a[start] + a[end] < x)
				start++;
		}
		return (new int[] { -1, -1 });
	}

	public static void main(String[] args) {
		int[] a = checkSum(new int[] { 1, 2, 3, 4 }, 6);
		for (int el : a) {
			System.out.println(el);
		}
	}
}
