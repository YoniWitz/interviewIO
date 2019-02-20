package backtrackingProblems;

public class TwoDMovementMazeFirst {
	static int[][] maze = { { 0, 1, 1, 1 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 0 } };

	private static boolean twoDMovementMaze(int[][] maze, int i, int j) {
		// base case
		if (i >= maze.length || j >= maze[0].length || maze[i][j] == 1) {
			return false;
		}
		if (i == maze.length - 1 && j == maze[0].length - 1) {
			System.out.println(i + " " + j);
			return true;
		}

		// meat
		if (twoDMovementMaze(maze, i + 1, j) || twoDMovementMaze(maze, i, j + 1)) {
			System.out.println(i + " " + j);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		twoDMovementMaze(maze, 0, 0);

	}

}
