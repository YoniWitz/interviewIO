package permutationsUsingAuxiliaryBuffer;

public class CoinChangeProblemFirst {
	static void reachTarget(int[] a, int x) {
		if (a == null || a.length == 0) {
			return;
		}

		int[] auxBuffer = new int[x];

		reachTargetHelper(a, auxBuffer, 0, 0, 0, x);
	}

	static void reachTargetHelper(int[] coins, int[] auxBuffer, int coinsIndex, int bufferIndex, int sum, int target) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			printBuffer(auxBuffer, bufferIndex);
			return;
		}

		for (int i = 0; i < coins.length; i++) {
			auxBuffer[bufferIndex] = coins[i];
			reachTargetHelper(coins, auxBuffer, i + 1, bufferIndex + 1, sum + coins[i], target);
		}
	}

///////////////
	private static void printBuffer(int[] auxBuffer, int bufferIndex) {
		for (int i = 0; i < bufferIndex; i++) {
			System.out.print(auxBuffer[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		reachTarget(coins, 5);
	}

}
