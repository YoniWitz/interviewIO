package intro;

public class FibonacciTabulationFirst {
	public static void main(String[] str) {
		System.out.println(fibonacciTabulation(1));
	}
	public static int fibonacciTabulation(int k) {
		int[] fib = new int[k + 1];
		fib[0] = 1;
		fib[1] = 1;
		for(int i =2; i<k;i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib[k-1];
	}
}
