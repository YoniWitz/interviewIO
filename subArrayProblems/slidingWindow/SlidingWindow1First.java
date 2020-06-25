package slidingWindow;

public class SlidingWindow1First {
	public static void main(String[] str) {
		int[] a = { 1, 3, 4, 2, 3, 1, 7, 6 };
		int[] b = { 15, 3, 4, 2, 3, 1, 7, 6 };
		int[] c = {  };
		int target1 = 140;
		int target2 = 14;
		int target3 = 15;

		subArraySumK(a, target1);
		subArraySumK(a, target2);
		subArraySumK(b, target1);
		subArraySumK(c, target1);
		subArraySumK(b, target3);
		subArraySumK(b, target2);
	}

	// two pointers, start and end.
	// loop through array:
	// if sum > target, increase start till < target
	// if target found, sysout and return
	private static void subArraySumK(int[] a, int target) {
		if(a == null) return;
		int start = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];

			while (sum > target && start <= i) { // sum = 17, start = 1, i = 4
				sum -= a[start++];
			}

			if (sum == target) {
				System.out.println("from " + start + "to " + i);
				return;
			}
		}
		System.out.println("no solution");
	}
}
