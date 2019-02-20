package homework1224;

public class MaxDiff {
	static int maxDiff(int[] graph) {
		if (graph == null || graph.length < 2) {
			return 0;
		}
		int min = graph[0];
		int maxTrade = graph[1] - graph[0];
		int trade;
		for (int i = 2; i < graph.length; i++) {
			min = graph[i - 1] < min ? graph[i - 1] : min;
			trade = graph[i] - min;
			maxTrade = trade > maxTrade ? trade : maxTrade;
		}
		return maxTrade;
	}

	public static void main(String[] args) {
		System.out.println(maxDiff(new int[] { 2, 3, 1, 4, 5, 7, 5, 4 }));
	}
}
