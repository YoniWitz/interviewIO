package hw0104;

import java.util.Arrays;
import java.util.Random;

public class SelectionAlgorithm {
	static int kThSmallestHelper(int[] a, int k) {
		if (a == null || k > a.length) {
			return -1;
		}
		Random rand = new Random();
		int randomIndex = rand.nextInt(a.length - 1);
		int pivotIndex = partition(a, randomIndex);
		if (pivotIndex == k) {
			return a[pivotIndex];
		} else if (pivotIndex > k) {
			return kThSmallestHelper(Arrays.copyOfRange(a, 0, pivotIndex - 1), k);
		} else {
			return kThSmallestHelper(Arrays.copyOfRange(a, pivotIndex + 1, a.length), k - pivotIndex);
		}
	}

	static int partition(int[] a, int randomIndex) {
		if (a == null || randomIndex >= a.length) {
			return -1;
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

	static void swap(int a[], int i, int j) {
		if (a == null || i >= a.length || j >= a.length) {
			return;
		}
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
