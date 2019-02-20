package dutchNationalFlag;

public class DutchNationalFlag1First {
	static void DNL(int[] a, int I) {
		if (a == null || a.length < 2 || I > a.length - 1) {
			return;
		}

		int num = a[I];
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
		int[] a = { 3, 5, 2, 6, 8, 4, 4, 6, 4, 4, 3 };
		int I = 5;
		DNL(a, I);
	}
}
