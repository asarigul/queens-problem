import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NQueensSolver {
    private final Board board;
    private final List<Board> result = new ArrayList<>();

    // previously used columns
    private Set<Integer> columns = new HashSet<>();

    // previously used diagonals
    private Set<Integer> rightDiagonals = new HashSet<>();
    private Set<Integer> leftDiagonals = new HashSet<>();

    private NQueensSolver(int boardSize) {
        this.board = new Board(boardSize);
    }

    private List<Board> solve() {
        tryRow(0);
        return result;
    }

    private void tryRow(int row) {
        // tried Queen in the last row => a valid solution
        if (row == this.board.size()) {
            result.add(board.copy());
            return;
        }

        for (int column = 0; column < board.size(); column++) {
            // skip if this column used before or on a diagonal used before
            if (isOnTheSameColumnOrDiagonal(row, column)) {
                continue;
            }

            // put Queen here
            tryThisCell(row, column);

            // recursively try next row
            tryRow(row + 1);

            // didn't work => remove
            undo(row, column);
        }
    }

    private boolean isOnTheSameColumnOrDiagonal(int row, int column) {
        return columns.contains(column) || //
                rightDiagonals.contains(row + column) || //
                leftDiagonals.contains(row - column);
    }

    private void tryThisCell(int row, int column) {
        columns.add(column);
        rightDiagonals.add(row + column);
        leftDiagonals.add(row - column);

        board.putQueen(row, column);
    }

    private void undo(int row, int column) {
        columns.remove(column);
        rightDiagonals.remove(row + column);
        leftDiagonals.remove(row - column);

        board.removeQueen(row, column);
    }

    public static void main(String[] args) {
        List<Board> solutions = new NQueensSolver(4).solve();
        List<List<String>> toExpectedOutput = solutions.stream().map(Board::data).collect(Collectors.toList());
        System.out.println(toExpectedOutput);
    }
}
