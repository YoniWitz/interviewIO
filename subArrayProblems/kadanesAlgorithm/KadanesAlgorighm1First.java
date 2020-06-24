package kadanesAlgorithm;

public class KadanesAlgorighm1First {
	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -1 };

		maxContSubarray(a);
	}

	//
	private static void maxContSubarray(int[] a) {
		if (a == null)
			return;

		int max = a[0];
		int localMax = a[0];
		
		for (int i = 1; i < a.length; i++) {
			localMax = Math.max(a[i], localMax + a[i]);
			max = Math.max(max, localMax);
		}
		System.out.println(max);
	}
}
