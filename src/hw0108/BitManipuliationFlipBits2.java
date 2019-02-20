package hw0108;

public class BitManipuliationFlipBits2 {
	static int flipBits(int a) {

		return ~a;
	}

	public static void main(String[] args) {
		int b = flipBits(0);
		System.out.println(Integer.toBinaryString(b));
	}
}
