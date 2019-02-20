package subArraySumProblems;

import java.util.Arrays;

public class SubArraySumProblem2Second {
	static int[] contiguousSumToX(int[] a, int X) {
		if (a == null) {
			return null;
		}
		int start = 0;
		int end = -1;
		int sum = 0;
		while (start < a.length && end < a.length) {
			if (sum == X) {
				return Arrays.copyOfRange(a, start, end + 1);
			} else if (sum > X) {
				sum -= a[start++];
			} else if (sum < X) {
				end++;
				if (end < a.length) {
					sum += a[end];
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = { 1, 4, 5, 3, 5, 1, 2, 4, 130 };
		int[] b = contiguousSumToX(a, 5);
		if (b != null) {
			for (int el : b) {
				System.out.print(el + " ");
			}
		}
	}
}
