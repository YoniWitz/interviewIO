package specialTricks;

import java.util.Arrays;

public class ReverseWordInSentenceFirst {
	public static void main(String[] str) {
		char[] string = { 'f', 'u', 'c', 'k' , ' ', 'y', 'o', 'u'};
		//reverseString(string, 0, string.length);
		reverseWordOrderInSentence(string);
		System.out.println(Arrays.toString(string));
	}

	// reverse entire string, then reverse the words
	public static void reverseWordOrderInSentence(char[] string) {
		if (string == null || string.length == 0) {
			return;
		}

		reverseString(string, 0, string.length);
		
		int beginningOfWord = 0;

		for (int i = 0; i < string.length; i++) {
			if (string[i] == ' ') {				
				if(i > beginningOfWord)
					reverseString(string, beginningOfWord, i);
				beginningOfWord = i + 1;
			}
		}
		reverseString(string, beginningOfWord, string.length);
	}

	private static void reverseString(char[] string, int start, int end) {
		char temp;
		for (int i = start, j = end - 1; i < j; i++) {
			temp = string[i];
			string[i] = string[j];
			string[j] = temp;
			j--;
		}
	}
}
