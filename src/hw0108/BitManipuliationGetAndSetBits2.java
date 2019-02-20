package hw0108;

public class BitManipuliationGetAndSetBits2 {
	static int getBitAtIndex(int a, int n) {
		return (a >> n & 1);
	}

	public static void main(String[] args) {
		int b = getBitAtIndex(5, 1);
		System.out.println(Integer.toBinaryString(b));
	}
}
