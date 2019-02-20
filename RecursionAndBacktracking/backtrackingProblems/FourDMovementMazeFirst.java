package backtrackingProblems;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class FourDMovementMazeFirst {
	static int[][] maze = { { 0, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 } };

	private static boolean fourDMovementMaze(int[][] maze, int i, int j, Pair<Integer, Integer> thisPair) {
		// base case
		if (i >= maze.length || j >= maze[0].length || i < 0 || j < 0 || maze[i][j] == 1
				|| (i == thisPair.getKey() && j == thisPair.getValue())) {
			return false;
		}
		if (i == maze.length - 1 && j == maze[0].length - 1) {

			return true;
		}

		thisPair = new Pair<>(i, j);

		List<Pair<Integer, Integer>> points = new ArrayList<Pair<Integer, Integer>>();

		points.add(new Pair<Integer, Integer>(i - 1, j));
		points.add(new Pair<Integer, Integer>(i + 1, j));
		points.add(new Pair<Integer, Integer>(i, j + 1));
		points.add(new Pair<Integer, Integer>(i, j - 1));

		for (Pair<Integer, Integer> point : points) {
			if (fourDMovementMaze(maze, point.getKey(), point.getValue(), thisPair)) {
				System.out.println(point.getKey() + " " + point.getValue());
				return true;
			}
		}
		// thisPair = new Pair<>(-1, -1);
		return false;
	}

	public static void main(String[] args) {
		Pair<Integer, Integer> thisPair = new Pair<>(-1, -1);
		fourDMovementMaze(maze, 0, 0, thisPair);
	}

}
