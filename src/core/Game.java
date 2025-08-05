package core;
import java.util.Random;
import model.*;

public class Game {
    private final Grid grid;
    private final long seed;
    private final int numGenerations;

    public Game(int rows, int columns, long seed, int numGenerations) {
        grid = new Grid(rows, columns);
        this.seed = seed;
        this.numGenerations = numGenerations;
    }

    public void printConfig() {
        System.out.println("GAME OF LIFE CONFIGURATION");
        System.out.println("ROWS: " + grid.getRows());
        System.out.println("COLUMNS: " + grid.getColumns());
        System.out.println("SEED: " + seed);
        System.out.println("# GENERATIONS: " + numGenerations);
    }

    public void run() {
        Random rd = new Random(seed);

        for (int i = 0; i < grid.getRows(); ++i) {
            for (int j = 0; j < grid.getColumns(); ++j) {
                grid.populate(i, j, rd.nextBoolean() ? 'O' : ' ');
            }
        }

        Generation currentGen = new Generation(grid);
        System.out.println("Starting Civilization");
        currentGen.print();
        System.out.println("\n");

        for (int i = 1; i <= numGenerations; ++i) {
            System.out.println("Generation " + i);
            currentGen = currentGen.next();
            currentGen.print();
            System.out.println("-".repeat(grid.getColumns()) + "\n");
        }
    }
}
