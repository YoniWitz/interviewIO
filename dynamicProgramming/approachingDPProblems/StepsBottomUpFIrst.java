package approachingDPProblems;

import java.util.Arrays;

public class StepsBottomUpFirst {

	public static void main(String[] args) {
		int[] options = { 1, 3, 5 };
		int steps = 8;
		System.out.println(stepsBottomUp(options, steps));
	}

	public static int stepsBottomUp(int[] options, int steps) {
		if (options == null || options.length == 0)
			return -1;

		int[] ways = new int[steps + 1];
		ways[0] = 1;

		for (int i = 0; i <= steps; i++) {
			for (int j = 0; j < options.length; j++) {
				if (i + options[j] <= steps)
					ways[i + options[j]] += ways[i];
			}
		}
		System.out.println(Arrays.toString(ways));
		return ways[steps];
	}

}
