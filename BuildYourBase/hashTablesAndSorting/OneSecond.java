package hashTablesAndSorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OneSecond {
	static boolean findDup1(int[] a) {
		if (a == null || a.length < 2)
			return false;
		Set<Integer> mySet = new HashSet<>();
		for (Integer el : a) {
			if (mySet.contains(el))
				return true;
			else
				mySet.add(el);
		}
		return false;
	}

	static boolean findDup2(int[] a) {
		if (a == null || a.length < 2) {
			return false;
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length - 1;) {
			if (a[i] == a[++i])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 3, 7, 9, 1 };
		int[] b = { 1, 2, 8, 5, 3, 7, 9 };
		System.out.println(findDup1(a));
		System.out.println(findDup2(b));
		System.out.println(findDup1(a));
		System.out.println(findDup2(b));

	}
}
