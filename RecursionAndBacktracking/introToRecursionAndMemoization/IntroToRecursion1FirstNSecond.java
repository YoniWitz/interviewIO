package introToRecursionAndMemoization;

import java.util.HashMap;
import java.util.Map;

public class IntroToRecursion1FirstNSecond {
	static Map<Integer, Integer> fiboMap = new HashMap<Integer, Integer>();
	static int result;

	static int nthFibo(int n) {
		//System.out.print("f" + n + " ");
		if (n == 1 || n == 2) {
			return 1;
		} else {

			return nthFibo(n - 1) + nthFibo(n - 2);
		}
	}

	static int nthFiboMem(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (fiboMap.containsKey(n)) {
			return fiboMap.get(n);
		} else {
			result = nthFiboMem(n - 2) + nthFiboMem(n - 1);
			fiboMap.put(n, result);
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(nthFibo(20));
		System.out.println(nthFiboMem(20));

	}
}
