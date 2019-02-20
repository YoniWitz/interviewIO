package subArraySumProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class subArraySumProblems3Second {
	static int[] findSumZero(int[] a) {
		if (a == null || a.length == 0)
			return null;

		int sum = 0;
		Map<Integer, Integer> sums = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				return Arrays.copyOfRange(a, i, i + 1);
			sum += a[i];
			if (sum == 0)
				return Arrays.copyOfRange(a, 0, i + 1);
			if (sums.containsKey(sum))
				return Arrays.copyOfRange(a, sums.get(sum) + 1, i + 1);
			sums.put(sum, i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = { -1, -1, 3, 1, -100, 2, 3, -1, 2 };
		int[] b = findSumZero(a);
		if (b != null) {
			for (int el : b) {
				System.out.print(el + " ");
			}
		}
	}

}
