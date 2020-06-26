package binarySearchWithDups;

public class BinarySearchWithDups2First {
	// if T is found, place next to.
	// if T not found, place in mid
	static int placeT(int[] A, int T) {
		if (A == null)
			return -1;

		if(A.length == 0) {
			return 0;
		}
		int start = 0;
		int end = A.length - 1;
		int mid = 0;
		
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (T < A[mid]) {
				end = mid - 1;
			}
			if (T > A[mid])
				start = mid + 1;

			if (T == A[mid])
				return mid + 1;
		}
		if (A[mid] > T)
			return mid;
		else {
			return mid + 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(placeT(new int[] {10,20,40,50,60,80}, 300));
	}
}
