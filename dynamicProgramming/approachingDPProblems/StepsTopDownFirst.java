package approachingDPProblems;

import java.util.Arrays;
import java.util.HashMap;

public class StepsTopDownFirst {
	public static void main(String[] args) {
		int[] options = { 1, 3, 5 };
		int steps = 8;
		System.out.println(stepsTopDownRecursiveMemoization(new HashMap<>(), options, steps));
	}

	public static int stepsTodDown(int[] options, int steps) {
		if (options == null || options.length == 0)
			return -1;

		int[] ways = new int[steps + 1];
		ways[0] = 1;
		for (int i = 0; i <= steps; i++) {
			for (int j = 0; j < options.length; j++) {
				if (i - options[j] >= 0) {
					ways[i] += ways[i - options[j]];
				}
			}
		}

		System.out.println(Arrays.toString(ways));
		return ways[steps];
	}

	// recursive: base case, when steps equal 1 or zero, return 1. if smaller than
	// zero return null;
	// otherwise loop through options and recurse
	public static int stepsTopDownRecursive(int[] options, int steps) {
		if (steps == 1 || steps == 0)
			return 1;
		if (steps < 0)
			return 0;

		int sum = 0;
		for (int option : options) {
			sum += stepsTopDownRecursive(options, steps - option);
		}
		return sum;
	}

	public static int stepsTopDownRecursiveMemoization(HashMap<Integer, Integer> stepsMap, int[] options, int steps) {
		if (steps == 1 || steps == 0)
			return 1;
		if (steps < 0)
			return 0;

		int sum = 0;
		for (int option : options) {
			if (!stepsMap.containsKey(steps - option))
				stepsMap.put(steps - option, stepsTopDownRecursiveMemoization(stepsMap, options, steps - option));

			sum += stepsMap.get(steps - option);
		}
		return sum;
	}
}
