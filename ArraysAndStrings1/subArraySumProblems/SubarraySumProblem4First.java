package subArraySumProblems;

import java.util.HashMap;

public class SubarraySumProblem4First {
	static int[] subArraySumK(int[] array, int K) {
		if (array == null) {
		} else {
			HashMap<Integer, Integer> arrayHash = new HashMap<>();
			int sum = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == K) {
					return new int[] { i, i };
				} else {
					sum += array[i];
					if (sum == K) {
						return new int[] { 0, i };
					} else {
						if (arrayHash.containsKey(sum - K)) {
							return new int[] { arrayHash.get(sum - K) + 1, i };
						} else {
							arrayHash.put(sum, i);
						}
					}
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[] a = subArraySumK(new int[] { 0, 2, -1, 7, -1 }, 5);
		for (int el : a) {
			System.out.println(el);
		}
	}
}
