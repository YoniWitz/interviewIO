package hw0108;

public class AddArrays {
	static int[] addArrays(int[] a, int[] b) {
		if (a == null || b == null) {
			return new int[] {};
		}
		int maxLength = a.length > b.length ? a.length : b.length;
		int sum;
		int[] result = new int[maxLength + 1];
		int carry = 0;
		for (int i = 0; i < maxLength; i++) {
			sum = (i < a.length ? a[i] : 0) + (i < b.length ? b[i] : 0) + carry;
			result[i] = sum % 10;
			carry = sum / 10;
		}
		result[maxLength] = carry;
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1 };
		int[] b = { 2, 2, 3, 3 };
		int[] result = addArrays(a, b);
		for (int el : result) {
			System.out.println(el);
		}
	}
}
