package specialTricks;

public class LongestPalindromFirst {

	public static void main(String[] str) {
		String string = "agvgareer";
		System.out.println(longestPalindrom(string));
	}

	public static String longestPalindrom(String str) {
		if (str == null || str.length() == 0)
			return null;

		int center = 0;
		int count;
		int maxPalindrom = 0;
		int offset;
		boolean evenPalindrom = false;
		// look for odd palindrom
		for (int i = 1; i < str.length() - 1; i++) {
			count = 0;
			offset = 1;
			while (i - offset > -1 && i + offset < str.length() && str.charAt(i - offset) == str.charAt(i + offset)) {
				count++;
				offset++;
			}

			if (count > maxPalindrom) {
				maxPalindrom = count;
				center = i;
			}
		}

		// look for even palindrom
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count = 1;
				offset = 1;

				while (i - offset > -1 && i + 1 + offset < str.length()
						&& str.charAt(i - offset) == str.charAt(i + 1 + offset)) {
					count++;
					offset++;
				}

				if (count > maxPalindrom) {
					evenPalindrom  = true;
					maxPalindrom = count;
					center = i + 1;
				}
			}
		}
		if(evenPalindrom) {
			return str.substring(center - maxPalindrom, center + maxPalindrom);
		}
		return str.substring(center - maxPalindrom, center + maxPalindrom + 1);
	}
}
