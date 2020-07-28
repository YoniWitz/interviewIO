package approachingDPProblems;

import java.util.Arrays;

public class CoinChangeFirst {

	public static void main(String[] args) {
		int[] coinDenominations = {1,2,5};
		int target = 5;
		
		System.out.println(coinChange(coinDenominations, target));

	}
	
	public static int coinChange(int[] coinDenominations, int target) {
		if(coinDenominations == null || coinDenominations.length == 0) {
			return -1;
		}
		
		int[] ways = new int[target + 1];
		ways[0] = 1;
		
		for(int i =0; i<=target; i++) {
			for(int j =0; j< coinDenominations.length; j++) {
				if(i + coinDenominations[j] <= target)
				ways[i + coinDenominations[j]]++;
			}
		}
		
		System.out.println(Arrays.toString(ways));
		return ways[target];
	}
}
