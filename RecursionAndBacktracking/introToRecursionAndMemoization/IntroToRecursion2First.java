package introToRecursionAndMemoization;

public class IntroToRecursion2First {
	static double CalcPower(int x, int n) {
		if (n == 0) {
			return 1;
		}

		if (x == 0) {
			if (n < 0)
				return 1d / 0.000000001;
			return 0;
		}

		int halfResult = nPower(x, Math.abs(n) / 2);
		int result = halfResult * halfResult;

		if (n > 0) {
			if (n % 2 == 0) {
				return result;
			} else {
				return x * result;
			}
		} else {
			if (n % 2 == 0)
				return 1d / (result);
			else
				return 1d / (x * result);
		}

	}

	public static int nPower(int x, int n) {
		if (n == 1)
			return x;

		return x * nPower(x, n - 1);
	}

	public static void main(String[] args) {
		System.out.println(CalcPower(2, 2));
		System.out.println(CalcPower(-2, 3));
		System.out.println(CalcPower(2, -3));
		System.out.println(CalcPower(-2, -4));
		System.out.println(CalcPower(-2, -3));
	}
}
