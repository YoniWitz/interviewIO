package introToRecursionAndMemoization;

public class IntroToRecursionTwoFirst {
	static int CalcPower(int x, int n) {
		if (n == 0) {
			return 1;
		}

		return x * CalcPower(x, n - 1);
	}

	public static void main(String[] args) {
		System.out.println(CalcPower(5, 2));
	}
}
