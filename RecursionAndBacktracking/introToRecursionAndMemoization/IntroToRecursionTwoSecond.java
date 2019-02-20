package introToRecursionAndMemoization;

public class IntroToRecursionTwoSecond {

	static int nPower(int x, int n) {
		if (n == 0)
			return 1;
		return nPower(x, n - 1) * x;
	}

	public static void main(String[] args) {
		System.out.println(nPower(6, 3));
	}

}
