package introImpl;

public class FindKSmallestInArraySecond {

	public static void main(String[] args) {
		int[] array = { 1, 4, 6, 7, 1, 2, 0 };
		int k = 7;

		System.out.println(findKSmallestInArray(array, k - 1, 0, array.length - 1));
	}

	// a=[7,4,1,2,11,9], k=2 return 4 (assuming k is 1 indexed)
	// a=[1, 4, 6, 7, 1, 2, 0], k=2 return 1 (assuming k is 1 indexed)
	public static int findKSmallestInArray(int[] array, int k, int start, int end) {
		if (array == null || array.length < k || end >= array.length || start >= array.length)
			return -1;

		if(start < end) {
		int pivot = (int) (Math.random() * 100 % (end - start) + start);

		int returnedIndex = partition(array, start, end, pivot);

		if (returnedIndex > k)
			return findKSmallestInArray(array, k, start, returnedIndex - 1);
		else if (returnedIndex < k)
			return findKSmallestInArray(array, k, returnedIndex + 1, end);
		else
			return array[returnedIndex];
		}
		else
		{
			return array[k];
		}
	}

	private static int partition(int[] array, int start, int end, int pivot) {
		if (array == null || start >= array.length || end >= array.length || pivot >= array.length) {
			return -1;
		}

		int left = start;
		int savePivot = array[pivot];

		swap(array, pivot, start);

		for (int i = start + 1; i <= end; i++) {
			if (array[i] <= savePivot) {
				swap(array, left + 1, i);
				left++;
			}
		}
		swap(array, left, start);
		return left;
	}

	private static void swap(int[] array, int a, int b) {
		if (array == null || a >= array.length || b >= array.length) {
			return;
		}

		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
