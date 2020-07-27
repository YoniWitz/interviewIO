package mergeAndQuickSort;

import java.util.Arrays;

public class MergeAndQuickSortFirst {

	public static void main(String[] args) {
//		int[] array1 = new int[1];
//		int[] array3 = { 4, 3 };
//		array1 = array3;
//		array1[0] = 67;
//
//		System.out.println(Arrays.toString(array1));
//		System.out.println(Arrays.toString(mergeSort(array3)));

		int[] array = { 3, 2, 4, 1, 6, 3, 7, 5 };
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}

//	public static int[] mergeSort(int[] unsorted) {
//		if (unsorted == null || unsorted.length == 0)
//			return null;
//
//		mergeSortHelper(unsorted);
//		return unsorted;
//	}
//
//	public static void mergeSortHelper(int[] unsorted) {
//		if (unsorted == null || unsorted.length <= 1)
//			return;
//
//		int mid = unsorted.length / 2;
//		int[] unsorted1 = Arrays.copyOfRange(unsorted, 0, mid);
//		int[] unsorted2 = Arrays.copyOfRange(unsorted, mid, unsorted.length);
//		mergeSortHelper(unsorted1);
//		mergeSortHelper(unsorted2);
//		merge(unsorted, unsorted1, unsorted2);
//	}
//
//	public static void merge(int[] unsorted, int[] sorted1, int[] sorted2) {
//		if (sorted1 == null || sorted2 == null)
//			return;
//
//		int index1 = 0;
//		int index2 = 0;
//		int indexUnsorted = 0;
//
//		while (index1 < sorted1.length && index2 < sorted2.length) {
//			if (sorted1[index1] < sorted2[index2]) {
//				unsorted[indexUnsorted++] = sorted1[index1++];
//			} else {
//				unsorted[indexUnsorted++] = sorted2[index2++];
//			}
//		}
//		while (index1 < sorted1.length) {
//			unsorted[indexUnsorted++] = sorted1[index1++];
//		}
//		while (index2 < sorted2.length) {
//			unsorted[indexUnsorted++] = sorted2[index2++];
//		}
//	}

	public static void quickSort(int[] unsorted) {
		if (unsorted == null || unsorted.length <= 1)
			return;

		quickSortHelper(unsorted, 0, unsorted.length - 1);
	}

	public static void quickSortHelper(int[] unsorted, int start, int end) {
		if (start < 0 || end >= unsorted.length || start >= end)
			return;

		int mid = partition(unsorted, start, end);
		quickSortHelper(unsorted, start, mid - 1);
		quickSortHelper(unsorted, mid + 1, end);
	}

	public static int partition(int[] unsorted, int start, int end) {
		int mid = start + (end - start) / 2;
		int pivot = unsorted[mid];
		int rightIndex = end;
		int leftIndex = start;
		int i = start;

		while (i <= rightIndex) {
			if (unsorted[i] < pivot) {
				int temp = unsorted[i];
				unsorted[i] = unsorted[leftIndex];
				unsorted[leftIndex] = temp;
				leftIndex++;
				i++;
			} else if (unsorted[i] > pivot) {
				int temp = unsorted[i];
				unsorted[i] = unsorted[rightIndex];
				unsorted[rightIndex] = temp;
				rightIndex--;
			}

			else {
				i++;
			}
		}
		return leftIndex;
	}
}
