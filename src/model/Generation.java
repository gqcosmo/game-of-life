package model;

public class Generation {
    private final Grid grid;

    public Generation(Grid grid) {
        this.grid = grid;
    }

    // returns the next generation
    public Generation next() {
        Grid nextGrid = new Grid(grid);

        for (int i = 0; i < grid.getRows(); ++i) {
            for (int j = 0; j < grid.getColumns(); ++j) {
                int numNeighbors = countAliveNeighbors(i, j);
                boolean isAlive = grid.at(i, j) == 'O';

                if (isAlive) {
                    isAlive = numNeighbors == 2 || numNeighbors == 3;
                } else {

                    isAlive = numNeighbors == 3;
                }

                nextGrid.populate(i, j, isAlive ? 'O' : ' ');
            }
        }

        return new Generation(nextGrid);
    }

    public void print() {
        grid.print();
    }

    private int countAliveNeighbors(int row, int col) {
        char[] chars = grid.getNeighbors(row, col);

        int alive = 0;
        for (char ch : chars) {
            if (ch == 'O') ++alive;
        }

        return alive;
    }
}
