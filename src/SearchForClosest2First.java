

public class SearchForClosest2First {
	static int findClosest(int[] array, int num) {
		if (array == null) {
			return -1;
		} else {
			int start = 0;
			int end = array.length - 1;
			int closest = 0;
			int middle;
			while (start <= end) {
				middle = start + (end - start) / 2;
				if (array[middle] == num) {
					return middle;
				} else {
					closest = getCloser(array, middle, closest, num);
					if (array[middle] > num) {
						end = middle - 1;
					}
					if (array[middle] < num) {
						start = middle + 1;
					}
				}
			}

			return (array[closest] > num ? closest : closest + 1);
		}
	}

	private static int getCloser(int[] array, int middle, int closest, int num) {
		if (Math.abs(array[middle] - num) < Math.abs(array[closest] - num)) {
			return middle;
		} else {
			return closest;
		}
	}

	public static void main(String[] args) {
		System.out.println(findClosest(new int[] { 1, 2, 4, 5, 6, 8 }, 4));
	}
}
