package prefixSums;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

public class PrefixSums1First {
	private static Pair<Integer, Integer> contiguousSubArrayZero(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		if (array[0] == 0) {
			return new Pair<>(0, 0);
		}
		int[] commonDiffs = new int[array.length];
		commonDiffs[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] == 0) {
				return new Pair<>(i, i);
			}
			commonDiffs[i] = commonDiffs[i - 1] + array[i];
			if (commonDiffs[i] == 0) {
				return new Pair<>(0, i);
			}
		}
		Map<Integer, Integer> commonDiffsMap = new HashMap<>();
		for (int i = 0; i < commonDiffs.length; i++) {
			if (commonDiffsMap.containsKey(commonDiffs[i])) {
				return new Pair<>(commonDiffsMap.get(commonDiffs[i]) + 1, i);
			}
			commonDiffsMap.put(commonDiffs[i], i);
		}
		return new Pair<>(-1, -1);
	}

	public static void main(String[] args) {
		Pair<Integer, Integer> pair = contiguousSubArrayZero(new int[] { -20, -10, 2, 1, -4, 2, 3, -18, 8 });
		System.out.println(pair.getKey() + " " + pair.getValue());
	}
}
