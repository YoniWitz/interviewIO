package traverseBothEnds;

public class TraversingFromBothEnds3First {
	static void continuousSubarray(int[] a) {
		int start = 0;
		int end = 0;
		if (a == null || a.length < 2) {
		} else {
			start = 0;
			end = a.length - 1;
			while (end > start) {
				if (a[end] < a[end - 1]) {
					break;
				}
				end--;
			}
			while (start < end) {
				if (a[start] > a[start + 1]) {
					break;
				}
				start++;
			}
		}
		System.out.println(start + " " + end);
	}

	public static void main(String[] args) {
		int[] a = { 0, 2, 5, 3, 4, 1 };
		continuousSubarray(a);
	}
}
