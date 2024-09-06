import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    // 1 row = 1 String
    private final List<String> rows;

    public Board(int size) {
        this(size, ".");
    }

    private Board(int size, String emptyCellVal) {
        this.rows = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            rows.add(emptyCellVal.repeat(size));
        }
    }

    private Board(List<String> data) {
        this.rows = data;
    }

    public void print() {
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i));
        }
    }

    public int size() {
        return rows.size();
    }

    public List<String> data() {
        return this.rows;
    }

    public Board copy() {
        return new Board(this.rows.stream().map(s -> new String(s)).collect(Collectors.toList()));
    }

    public void putQueen(int row, int column) {
        put(row, column, 'Q');
    }

    public void removeQueen(int row, int column) {
        put(row, column, '.'); // fixme
    }

    private void put(int row, int column, char c) {
        char[] s = this.rows.get(row).toCharArray();
        s[column] = c;
        this.rows.set(row, String.valueOf(s));
    }
}
