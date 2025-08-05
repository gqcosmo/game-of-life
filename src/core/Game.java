package core;
import java.util.Random;
import model.*;

public class Game {
    Grid grid;
    int rows;
    int columns;
    long seed;
    int numGenerations;

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
                boolean isAlive = rd.nextBoolean();
                grid.populate(i, j, (isAlive) ? 'O' : ' ');
            }
        }

        Generation start = new Generation(grid);
        Generation[] gens = new Generation[numGenerations+1];
        gens[0] = start;

        System.out.print("Starting Civilization");
        start.print();
        System.out.println("\n");

        for (int i = 1; i <= numGenerations; ++i) {
            System.out.println("Generation " + i);
            gens[i] = gens[i-1].next();
            gens[i].print();
            System.out.println("-".repeat(columns) + "\n");
        }
    }
}
