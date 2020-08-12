package hashTableHashFunction;

public class HashCodeImplementationFirst {
	public static long hashCode(String key) {
		if (key == null) {
			return -1;
		}
		int x = 31;
		long hash = 0;
		for (char el : key.toCharArray()) {
			hash = hash * x + el;
		}
		return hash;
	}

	public static void main(String[] args) {
		System.out.println(hashCode("cat"));

	}

}
