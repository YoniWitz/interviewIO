package hw0108;

public class BitManipuliationLSB1 {
	static int countBits(int a) {
		int count = 0;
		while (a != 0) {
			count++;
			a = a & (a - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countBits(6));
	}
}
