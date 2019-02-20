package hashTablesAndSorting;

import java.util.HashSet;
import java.util.Set;

public class OneFirst {
	static boolean checkDups(int[] a) {
		if (a == null || a.length < 2) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			if (set.contains(i)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.print(checkDups(new int[] { 1, 3, 4 }));
	}
}
