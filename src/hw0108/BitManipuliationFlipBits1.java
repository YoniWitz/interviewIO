package hw0108;

public class BitManipuliationFlipBits1 {
	static int flipBitsAtIndex1And5(int a) {
		return a ^ 17;
	}

	public static void main(String[] args) {
		int b = flipBitsAtIndex1And5(0);
		System.out.println(Integer.toBinaryString(b));
	}
}
