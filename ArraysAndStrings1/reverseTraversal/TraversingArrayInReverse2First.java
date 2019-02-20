package reverseTraversal;

public class TraversingArrayInReverse2First {
	static void reverseSentence(String s) {
		if (s == null) {
		} else {
			StringBuilder sb = new StringBuilder();
			StringBuilder sbTemp = new StringBuilder();

			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) != ' ')
					sbTemp.insert(0, s.charAt(i));
				else {
					sb.append(sbTemp).append(' ');
					sbTemp.setLength(0);
				}

			}
			sb.append(sbTemp);
			System.out.println(sb);
		}
	}

	public static void main(String[] args) {
		reverseSentence("fuck you");
	}
}
