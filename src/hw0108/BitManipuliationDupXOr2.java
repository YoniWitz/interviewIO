package hw0108;

public class BitManipuliationDupXOr2 {
	static int findSinglegNum(int[] a) {
		if (a == null) {
			return 0;
		}
		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			answer ^= a[i];
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(findSinglegNum(new int[] { 3, 7, 3, 5, 5 }));
	}
}
