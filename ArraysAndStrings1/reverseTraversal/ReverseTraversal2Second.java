package reverseTraversal;

public class ReverseTraversal2Second {
	static void reverseString(String s) {
		if (s == null) {
		} else {
			StringBuilder sb = new StringBuilder();
			String[] stringArray = s.split(" ");
			if (stringArray.length != 0) {
				for (int i = stringArray.length - 1; i >= 0; i--) {
					sb.append(stringArray[i] + " ");
				}
				s = sb.toString();
			}
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		reverseString("I love Pine. trees");
		reverseString("trees");
		reverseString(" ");
		reverseString("   ");
		reverseString("");
		String s = null;
		reverseString(s);
	}
}
