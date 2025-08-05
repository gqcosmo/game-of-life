package model;

public class Generation {
    private final Grid grid;

    public Generation(Grid grid) {
        this.grid = grid;
    }

    // returns the next generation
    public Generation next() {
        Grid nextGrid = new Grid(grid);

        System.out.println("Intial");
        grid.print();
        System.out.print("\n");

        for (int i = 0; i < grid.getRows(); ++i) {
            for (int j = 0; j < grid.getColumns(); ++j) {
                int numNeighbors = countAliveNeighbors(i, j);
                boolean alive = grid.at(i, j) == 'O';

                if (alive) {
                    alive = numNeighbors == 2 || numNeighbors == 3;
                } else {
                    alive = numNeighbors == 3;
                }

                nextGrid.populate(i, j, alive ? 'O' : ' ');
            }
        }

        System.out.println("New");
        nextGrid.print();
        System.out.println("\n");
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
