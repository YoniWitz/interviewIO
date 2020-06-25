package slidingWindow;

public class SlidingWindow2First {

	public static void main(String[] args) {
		String myStr = "whatwhywhere";
		longestUniqueSubstring(myStr);
		longestUniqueSubstring(null);
		longestUniqueSubstring("");
		longestUniqueSubstring("a");
	}

	// "whatwhywhere" --> "atwhy"
	// does it matter which?
	// start from beginning, keep adding more chars until hit an existing char. in
	// that case,
	// record the length, cut the rotten piece and keep on moving
	private static void longestUniqueSubstring(String myStr) {
		if(myStr == null) return;
		StringBuilder sb = new StringBuilder("");
		String result = "";
		int maxCount = 0;

		for (String ch : myStr.split("")) {
			if (sb.toString().contains(ch)) {			
				sb.delete(0, sb.toString().indexOf(ch) + 1);
			}
			
			sb.append(ch);
			
			if (sb.length() > maxCount) {
				maxCount = sb.length();
				result = sb.toString();
			}
		}
		System.out.println(result);
	}

}
