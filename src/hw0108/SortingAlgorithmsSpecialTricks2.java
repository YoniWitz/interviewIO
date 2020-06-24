package hw0108;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithmsSpecialTricks2 {
	static int[] pigeunSort(int[] a) {
		if (a == null)
			return null;

		@SuppressWarnings("unchecked")
		List<Integer>[] order = new ArrayList[10];
		for (int el : a) {
			if (order[el] == null) {
				order[el] = new ArrayList<>();
			}
			order[el].add(el);
		}
		int i = 0;
		for (List<Integer> list : order) {
			if (list != null)
				for (Integer el : list) {
					a[i++] = el;
				}
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 3, 1, 5, 7, 2 };
		for (int el : pigeunSort(a)) {
			System.out.println(el);
		}
	}
}
