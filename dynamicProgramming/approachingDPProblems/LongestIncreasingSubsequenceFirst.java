package approachingDPProblems;

import java.util.Arrays;

public class LongestIncreasingSubsequenceFirst {

	public static void main(String[] str) {
		int[] sequence = { 3, 4, -1, 0, 6, 2, 3 };

		System.out.println(longestIncreasingSubsequence(sequence));
	}

	//bottom up
	public static int longestIncreasingSubsequence(int[] sequence) {
		if (sequence == null)
			return -1;
		if (sequence.length <= 1)
			return sequence.length;

		int[] subsequences = new int[sequence.length];
		int max = 1;
		int j;

		for (int i = 0; i < sequence.length; i++) {
			subsequences[i] += 1;
			j = 0;
			while (j < i) {
				if (sequence[j] < sequence[i]) {
					subsequences[i] = Math.max(subsequences[j] + 1, subsequences[i]);
					max = Math.max(max, subsequences[i]);
				}
				j++;
			}
		}
		System.out.println(Arrays.toString(subsequences));
		return max;
	}
}
