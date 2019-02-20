package dutchNationalFlag;

public class DutchNationalFlag3First {
	static void DNL(int[] a) {
		if (a == null || a.length < 2) {
			return;
		}

		int num = 1;
		int low = -1;
		int mid = -1;
		int high = a.length;
		while (mid + 1 < high) {
			if (a[mid + 1] > num) {
				swap(a, mid + 1, --high);
			} else if (a[mid + 1] < num) {
				swap(a, ++mid, ++low);
			} else {
				mid++;
			}
		}

		for (int el : a)
			System.out.print(el + " ");
	}

	static void swap(int[] a, int i, int j) {
		if (i >= a.length || j >= a.length || i == j || i < 0 || j < 0) {
			return;
		}
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 0, 1, 2, 1, 0, 1, 2 };
		DNL(a);
	}
}
