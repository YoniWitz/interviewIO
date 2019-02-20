package hashTablesAndSorting;

import java.util.HashSet;

public class TwoFirst {
	private static int[] returnPair(int[] array, int x) {
		HashSet<Integer> elementSet = new HashSet<>();
		for (int i = 0; i < array.length; i++) {

			if (elementSet.contains(x - array[i]))
				return (new int[] { x - array[i], array[i] });
			else
				elementSet.add(array[i]);

		}
		return new int[] { -1 };
	}

	public static void main(String[] args) {
		int[] array = (returnPair(new int[] { 6, -1, 8, 5, 2, 1, 7 }, 4));
		for (int element : array) {
			System.out.println(element);
		}
	}
}
