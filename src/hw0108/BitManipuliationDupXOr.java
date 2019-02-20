package hw0108;

public class BitManipuliationDupXOr {
	static int findMissingNum(int[] a) {
		if (a == null) {
			return 0;
		}
		int num = 0;
		for (int i = 1; i <= a.length + 1; i++) {
			num = num ^ i;
		}
		for (int i = 0; i < a.length; i++) {
			num = num ^ a[i];
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(findMissingNum(new int[] { 1, 2, 4, 8, 7, 9, 5, 6 }));
	}
}
