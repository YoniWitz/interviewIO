package specialTricks;

public class RotationFirst {
	public static void main(String[] str) {
		String str1 = "bobcat";
		String str2 = "atbob";
		System.out.println(isRotation(str1, str2));
	}
		//append str1 to itself and check if str2 is included in there
		public static boolean isRotation(String str1, String str2) {
			if(str1 == null || str2 == null || str1.length() != str2.length()) return false;
			str1 +=str1;
			return str1.contains(str2);
		}
}
