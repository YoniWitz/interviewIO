package permutationsUsingAuxiliaryBuffer;

import java.util.HashMap;
import java.util.Map;

public class TwoFirst {
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

	static void printMnemonics(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		createMap();
		char[] auxBuffer = new char[a.length];
		printMnemonicsHelper(a, auxBuffer, 0, 0);
	}

	static void printMnemonicsHelper(int[] a, char[] auxBuffer, int aIndex, int bufferIndex) {
		if (aIndex == a.length) {
			printArray(auxBuffer);
			return;
		}

		Character[] letters = telephoneLetterMap.get(a[aIndex]);

		if (letters.length == 0)
			printMnemonicsHelper(a, auxBuffer, aIndex + 1, bufferIndex);

		for (Character ch : letters) {
			auxBuffer[bufferIndex] = ch;
			printMnemonicsHelper(a, auxBuffer, aIndex + 1, bufferIndex + 1);
		}
	}

	private static void printArray(char[] auxBuffer) {
		for (char ch : auxBuffer)
			System.out.print(ch);
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4 };
		printMnemonics(a);
	}

}
