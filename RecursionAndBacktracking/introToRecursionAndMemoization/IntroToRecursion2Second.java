package introToRecursionAndMemoization;

public class IntroToRecursion2Second {
	public static void main(String[] args) {
		System.out.println(nPower(2, 2));
		System.out.println(nPower(-2, 3));
		System.out.println(nPower(2, -3));
		System.out.println(nPower(-2, -4));
		System.out.println(nPower(-2, -3));
	}

	public static double nPower(int x, int n) {
		if (n == 0)
			return 1;

		if (x == 0) {
			if (n < 0)
				return 1d / 0.000000001;
			return 0;
		}

		int halfResult = positivePower(x, Math.abs(n) / 2);
		int result = halfResult * halfResult;
		if (n > 0) {
			if (n % 2 == 0)
				return result;
			else {
				return result * x;
			}
		} else if (n < 0) {
			if (n % 2 == 0)
				return 1d / (result);
			else {

				return 1d / (result * x);
			}
		}

		return 0.0;
	}

	private static int positivePower(int x, int n) {
		if (n == 1)
			return x;
		return x * positivePower(x, n - 1);
	}
}
