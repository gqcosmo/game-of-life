package model;

public class Grid {
    private final int rows;
    private final int columns;
    private final char[][] arr;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        arr = new char[rows][columns];
    }

    public Grid(Grid other) {
        rows = other.rows;
        columns = other.columns;
        arr = new char[rows][columns];

        for (int i = 0; i < rows; ++i) {
            System.arraycopy(other.arr[i], 0, arr[i], 0, columns);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public char at(int row, int col) {
        validateCoord(row, col);
        return arr[row][col];
    }

    public void populate(int row, int col, char value) {
        validateCoord(row, col);
        arr[row][col] = value;
    }

    public char[] getNeighbors(int row, int col) {
        validateCoord(row, col);
        char[] neighbors = new char[8];

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          {0,  1},
                { 1, -1}, {1,  0}, {1,  1}
        };

        for (int i = 0; i < 8; ++i) {
            int[] dir = directions[i];
            int newRow = (dir[0] + row + rows) % rows;
            int newCol = (dir[1] + col + columns) % columns;
            neighbors[i] = at(newRow, newCol);
        }

        return neighbors;
    }

    public void print() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.print(at(i, j));
            }
            System.out.print('\n');
        }
    }

    private void validateCoord(int row, int col) {
        if (row < 0 || row >= rows) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (col < 0 || col >= columns) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        Grid g = new Grid(4, 4);
        g.populate(0, 1, 'o');
        g.populate(0, 3, 'o');
        g.populate(1, 0, 'o');
        g.populate(1, 1, 'o');
        g.populate(1, 3, 'o');
        g.populate(3, 0, 'o');
        g.populate(3, 1, 'o');
        g.populate(3, 3, 'o');

        for (char ch : g.getNeighbors(0, 0)) {
            System.out.println(ch + " ");
        }
    }
}