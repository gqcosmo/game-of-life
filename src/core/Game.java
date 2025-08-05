package core;
import java.util.Random;
import model.*;

public class Game {
    private Grid grid;
    private int rows;
    private int columns;
    private long seed;
    private int numGenerations;

    public Game(int rows, int columns, long seed, int numGenerations) {
        grid = new Grid(rows, columns);
        this.rows = rows;
        this.columns = columns;
        this.seed = seed;
        this.numGenerations = numGenerations;
    }

    public void printConfig() {
        System.out.println("GAME OF LIFE CONFIGURATION");
        System.out.println("ROWS: " + rows);
        System.out.println("COLUMNS: " + columns);
        System.out.println("SEED: " + seed);
        System.out.println("# GENERATIONS: " + numGenerations);
    }

    public void run() {
        Random rd = new Random(seed);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
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
            //currentGen.print();
            System.out.println("-".repeat(columns) + "\n");
        }
    }
}
