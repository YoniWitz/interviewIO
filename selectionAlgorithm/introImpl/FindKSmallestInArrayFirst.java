package introImpl;

import java.util.Arrays;

public class FindKSmallestInArrayFirst {
	public static void main(String[] str) {
		int[] a = { 1, 4, 6, 7, 1, 2, 0 };
		int k = 7;

		System.out.println(kThSmallest(a, k - 1));
	}

	public static int kThSmallest(int[] a, int k) {
		if (a == null || k > a.length) {
			return -1;
		}

		if (k < a.length) {
			int randomIndex = (int) (Math.random() * 100 % a.length);
			int pivotIndex = partition(a, randomIndex);

			if (pivotIndex == k) {
				return a[pivotIndex];
			} else if (pivotIndex > k) {
				return kThSmallest(Arrays.copyOfRange(a, 0, pivotIndex), k);
			} else {
				return kThSmallest(Arrays.copyOfRange(a, pivotIndex + 1, a.length), k - pivotIndex -1);
			}
		} else {
			return a[0];
		}
	}

	public static int partition(int[] a, int randomIndex) {
		if (a == null || randomIndex >= a.length) {
			return -2;
		}
		swap(a, 0, randomIndex);

		int less = 0;

		for (int i = 1; i < a.length; i++) {
			if (a[i] <= a[0]) {
				swap(a, i, ++less);
			}
		}

		swap(a, 0, less);
		return less;
	}

	public static void swap(int a[], int i, int j) {
		if (a == null || i >= a.length || j >= a.length) {
			return;
		}
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
