package subArraySumProblems;

import java.util.Arrays;

public class subArraySumProblemTwoFirst {
	static int[] findContSubArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return null;
		}
		int start = 0;
		int end = 1;
		int sum = a[0];
		while (start <= a.length - 1 && end <= a.length - 1) {
			if (sum == x) {
				return Arrays.copyOfRange(a, start, end);
			} else if (sum > x) {
				sum -= a[start++];
			} else if (sum < x) {
				sum += a[end++];
			}

		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = findContSubArray(new int[] { 1, 2, 3, 4, 2, 3, 4, 6, 7, 5 }, 100);
		if (a != null)
			for (int el : a) {
				System.out.println(el);
			}
	}
}
