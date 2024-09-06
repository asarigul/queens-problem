public class MazeSolver {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 } }; // right and down

    public boolean solveMaze(int[][] maze) {
        return findPath(0, 0, maze);
    }

    private boolean findPath(int row, int col, int[][] maze) {
        // Base case: reached the bottom-right corner
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            return true;
        }

        // Check if the current cell is valid
        if (isSafe(row, col, maze)) {
            // Mark the cell as part of the solution path
            maze[row][col] = 2;

            // Explore the two possible directions (right and down)
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (findPath(newRow, newCol, maze)) {
                    return true;
                }
            }

            // If no path found, backtrack and unmark the cell
            maze[row][col] = 1;
        }

        return false; // no valid path found from this cell
    }

    private boolean isSafe(int row, int col, int[][] maze) {
        return row >= 0 && col >= 0 && row < maze.length && col < maze[0].length && maze[row][col] == 1;
    }

    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();
        int[][] maze = {
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 }
        };
        System.out.println(solver.solveMaze(maze));
    }
}
