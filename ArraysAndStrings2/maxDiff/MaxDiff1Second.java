package maxDiff;

public class MaxDiff1Second {

	public static void main(String[] str) {
		int[] prices = { 8, 14, 2, 5, 7, 3, 9, 5 };

		System.out.println(maxDiff(prices));
	}

	// [8,14,2,5,7,3,9,5] -> 7
	// the maximum trade for i is the difference between that and the minimum
	// before.
	// we keep track of minimum. then keep track of maximum difference and return
	public static int maxDiff(int[] prices) {
		if (prices == null || prices.length == 0)
			return -1;

		int maxDiff = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i - 1]);
			maxDiff = Math.max(maxDiff, prices[i] - min);
		}

		return maxDiff;
	}
}
