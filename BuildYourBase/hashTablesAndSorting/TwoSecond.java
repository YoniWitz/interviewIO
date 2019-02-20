package hashTablesAndSorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSecond {
	static int[] findPair1(int[] a, int x) {
		if (a == null || a.length < 2) {
			return new int[] {};
		}
		Set<Integer> mySet = new HashSet<>();
		for (int el : a) {
			if (mySet.contains(x - el)) {
				return new int[] { el, x - el };
			} else
				mySet.add(el);
		}
		return new int[] {};
	}

	static int[] findPair2(int[] a, int x) {
		if (a == null || a.length < 2)
			return new int[] {};
		Arrays.sort(a);
		int left = 0;
		int right = a.length - 1;
		int sum;
		while (left < right) {
			sum = a[left] + a[right];
			if (sum == x) {
				return new int[] { a[left], a[right] };
			} else if (sum > x) {
				right--;
			} else if (sum < x) {
				left++;
			}
		}
		return new int[] {};

	}

	public static void main(String[] args) {
		int[] a = { 7, 9, 3, 2, 4, };
		int[] b = findPair1(a, 12);
		int[] c = findPair2(a, 12);
		for (int el : b) {
			System.out.println(el);
		}
		for (int el : c) {
			System.out.println(el);
		}
	}
}
