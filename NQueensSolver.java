import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NQueensSolver {
    private final Board board;
    private final List<Board> result = new ArrayList<>();

    // put Queen in each column. don't select the same columns
    private Set<Integer> columns = new HashSet<>();
    // don't try the cells on the same left (-) diagonals
    private Set<Integer> leftDiagonals = new HashSet<>();
    // don't try the cells on the same right (+) diagonals
    private Set<Integer> rightDiagonals = new HashSet<>();

    private NQueensSolver(int boardSize) {
        this.board = new Board(boardSize);
    }

    private List<Board> solve() {
        backtrack(0);
        return result;
    } 

    private void backtrack(int row) {
        // trying Queen in the last row => a valid solution
        if(row == this.board.size()) {
            result.add(board.copy());
            return;
        }

        for(int column = 0; column < board.size(); column++) {
            // skip if on the same column, or on the same diagonals
            if (columns.contains(column) || rightDiagonals.contains(row + column)
                    || leftDiagonals.contains(row - column)) {
                continue;
            }

            columns.add(column);
            leftDiagonals.add(row + column);
            rightDiagonals.add(row - column);

            // put Q here
            board.putQueen(row, column);

            // try next row
            backtrack(row + 1);

            // didn't work => remove 
            columns.remove(column);
            leftDiagonals.remove(row + column);
            rightDiagonals.remove(row - column);
            board.removeQueen(row, column);
        }
    }

    public static void main(String[] args) {
        List<Board> solutions = new NQueensSolver(4).solve();
        List<List<String>> toExpectedOutput = solutions.stream().map(Board::data).collect(Collectors.toList());
        System.out.println(toExpectedOutput);
    }
}
