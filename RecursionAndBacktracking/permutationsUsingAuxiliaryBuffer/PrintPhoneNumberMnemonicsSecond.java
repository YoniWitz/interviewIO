package permutationsUsingAuxiliaryBuffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintPhoneNumberMnemonicsSecond {
	static Map<Integer, Character[]> telephoneLetterMap;

	private static Map<Integer, Character[]> createMap() {
		telephoneLetterMap = new HashMap<>();
		telephoneLetterMap.put(1, new Character[] {});
		telephoneLetterMap.put(2, new Character[] { 'a', 'b', 'c' });
		telephoneLetterMap.put(3, new Character[] { 'e', 'f', 'd' });
		telephoneLetterMap.put(4, new Character[] { 'h', 'i', 'g', });
		telephoneLetterMap.put(5, new Character[] { 'k', 'j', 'l' });
		telephoneLetterMap.put(6, new Character[] { 'm', 'n', 'o' });
		telephoneLetterMap.put(7, new Character[] { 'p', 'q', 'r', 's' });
		telephoneLetterMap.put(8, new Character[] { 't', 'u', 'v' });
		telephoneLetterMap.put(9, new Character[] { 'w', 'x', 'y', 'z' });
		telephoneLetterMap.put(0, new Character[] {});
		return null;
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 3, 4 };
		createMap();
		printPhoneNumberMnemonics(a);
	}

	private static void printPhoneNumberMnemonics(int[] a) {
		if (a == null || a.length == 0)
			return;

		Character[] auxLetters = new Character[a.length];
		int aIndex = 0;
		int lettersIndex = 0;

		printPhoneNumberMnemonicsHelper(a, auxLetters, aIndex, lettersIndex);
	}

	private static void printPhoneNumberMnemonicsHelper(int[] a, Character[] auxLetters, int aIndex, int lettersIndex) {
		if (aIndex == a.length) {
			System.out.println(Arrays.toString(Arrays.copyOfRange(auxLetters, 0, lettersIndex)));
			return;
		}

		Character[] letters = telephoneLetterMap.get(a[aIndex]);

		if (letters.length == 0)
			printPhoneNumberMnemonicsHelper(a, auxLetters, aIndex + 1, lettersIndex);

		for (Character letter : letters) {
			auxLetters[lettersIndex] = letter;
			printPhoneNumberMnemonicsHelper(a, auxLetters, aIndex + 1, lettersIndex + 1);
		}
	}
}
