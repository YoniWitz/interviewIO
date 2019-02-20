package dutchNationalFlag;

public class DutchNationalFlag2First {
	static void moveZeroes(int[] array) {
		if (array == null || array.length < 2) {
		} else {
			int start = 0;
			int end = array.length - 1;
			while (start < end) {
				if (array[start] == 0) {
					boolean bool = true;
					while (bool && start < end) {
						if (array[end] != 0) {
							swap(array, start, end);
							bool = false;
						}
						end--;
					}
				}
				start++;
			}
		}
		for (int e : array) {
			System.out.println(e);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 0, 8, 8, 8, 7 };
		moveZeroes(array);
	}
}
