package reverseTraversal;

public class TraversingArrayInReverse1Second {
	static void dupEven(int[] a) {
		if (a == null || a.length < 1) {
			return;
		}
		int end = a.length - 1;
		int i = findLastNum(a);
		while (i >= 0) {
			a[end--] = a[i];
			if (a[i] % 2 == 0) {
				a[end--] = a[i];
			}
			i--;
		}
	}

	static private int findLastNum(int[] a) {
		int endOfNum = a.length - 1;
		while (a[endOfNum] == -1) {
			endOfNum--;
		}
		;
		return endOfNum;
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 1, 0, 3, -1, -1, -1 };
		int[] b = { 1, 3, 1, 7, 3 };
		dupEven(a);
		for (int el : a) {
			System.out.print(el);
		}
		System.out.println();
		dupEven(b);
		for (int el : b) {
			System.out.print(el);
		}
	}
}
