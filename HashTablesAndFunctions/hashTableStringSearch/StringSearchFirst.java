package hashTableStringSearch;

import hashTableHashFunction.HashCodeImplementationFirst;

public class StringSearchFirst {

	public static void main(String[] str) {
//		
//		String str1 = "hello world from java";
//		String target = "orld";
//		System.out.println(stringSearch(str1, target));
	}

	// calculate target hash. then calculate str hash to the length of target.
	// then keep checking the hash value of same length, only removing from one side
	// and adding from the
	// other until there's a match. if we find a match, we compare the substring and
	// target
	// str1 = "hello world from java", target = "orl" => 7
	public static int stringSearch(String str, String target) {
		if (target == null || str == null || target.length() > str.length())
			return -1;

		long hashT = HashCodeImplementationFirst.hashCode(target);
		System.out.println("hashT: " + hashT);
		long hash = HashCodeImplementationFirst.hashCode(str.substring(0, target.length()));

		if (hashT == hash && target.equals(str))
			return 0;

		int x = 31;
		int xPow = 1;
		for (int i = 0; i < target.length() - 1; i++) {
			xPow *= x;
		}

		for (int i = 0; i < str.length() - target.length(); i++) {
			hash = (hash - str.charAt(i) * xPow) * x + str.charAt(i + target.length());
			System.out.println(hash);
			if (hashT == hash && target.equals(str.substring(i + 1, 1 + i + target.length())))
				return i + 1;
		}

		return -1;
	}

	

}
