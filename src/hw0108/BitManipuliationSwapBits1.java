package hw0108;

public class BitManipuliationSwapBits1 {
	static int swapIJ(int N, int i, int j) {
		int bit1 = BitManipuliationGetAndSetBits2.getBitAtIndex(N, i);
		int bit2 = BitManipuliationGetAndSetBits2.getBitAtIndex(N, j);

		if (bit1 == bit2) {
			return N;
		} else {
			return (N ^ (1 << i | 1 << j));
		}
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(swapIJ(6, 1, 2)));
	}
}
