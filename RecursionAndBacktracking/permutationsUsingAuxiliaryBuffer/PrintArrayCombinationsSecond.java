package permutationsUsingAuxiliaryBuffer;

import java.util.Arrays;

public class PrintArrayCombinationsSecond {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int length = 3;
		
		printArrayCombinations(a,length);
	}

	private static void printArrayCombinations(int[] a, int length) {
		if(a==null || length > a.length) return;
		
		int[] buffer = new int[length];
		int bufferIndex = 0;
		int startIndex = 0;
		printArrayCombinationsHelper(a, buffer, startIndex, bufferIndex);		
	}
	
	public static void printArrayCombinationsHelper(int[] a, int[] buffer, int startIndex,  int bufferIndex) {
		//if buffer is full
		if(bufferIndex == buffer.length) {
			System.out.println(Arrays.toString(buffer));
			return;
		}
		if (startIndex == a.length) {
			return;
		}
		
		for(int i = startIndex; i<a.length; i++) {
			buffer[bufferIndex] = a[i];
			printArrayCombinationsHelper(a, buffer, i + 1, bufferIndex + 1);
		}	
	}
}
