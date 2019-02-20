package hw0108;

public class BitManipuliationGetAndSetBits1 {
	static int setValueAtIndex(int num, int value, int index) {
		return value == 1 ? num | (1 << index) : num & (~1 << index);
	}

	public static void main(String[] args) {
		int b = setValueAtIndex(0, 1, 2);
		System.out.println(Integer.toBinaryString(b));
	}
}
