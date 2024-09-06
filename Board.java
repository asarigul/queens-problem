import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    // 1 row = 1 String
    private final List<String> data;

    public Board(int size) {
        this(size, ".");
    }

    private Board(int size, String emptyCellVal) {
        this.data = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            data.add(emptyCellVal.repeat(size));
        }
    }

    private Board(List<String> data) {
        this.data = data;
    }

    public void print() {
        for(int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    public int size() {
        return data.size();
    }

    public List<String> data() {
        return this.data;
    }

    public List<String> dataCopy() {
        return this.data.stream().map(s -> new String(s)).collect(Collectors.toList());
    }

    public Board copy() {
        return new Board(this.dataCopy());
    }

    public void putQueen(int row, int column) {
        put(row, column, 'Q');
    }

    public void removeQueen(int row, int column) {
        put(row, column, '.'); // fixme
    }

    private void put(int row, int column, char c) {
        char[] s = this.data.get(row).toCharArray();
        s[column] = c;
        this.data.set(row, String.valueOf(s)) ;
    }
}
