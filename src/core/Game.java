package core;
import java.io.IOException;
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

    public void run() {
        Random rd = new Random(seed);

        for (int i = 0; i < grid.getRows(); ++i) {
            for (int j = 0; j < grid.getColumns(); ++j) {
                grid.populate(i, j, rd.nextBoolean() ? 'O' : ' ');
            }
        }

        int ms = 750;
        Generation currentGen = new Generation(grid);
        print(0, currentGen);
        sleep(ms);
        clearTerminal();

        for (int i = 1; i <= numGenerations; ++i) {
            currentGen = currentGen.next();
            print(i, currentGen);
            sleep(ms);
            clearTerminal();
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    private void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }

    private void print(int generationNum, Generation generation) {
        System.out.println("GAME OF LIFE CONFIGURATION");
        System.out.println("ROWS: " + grid.getRows());
        System.out.println("COLUMNS: " + grid.getColumns());
        System.out.println("SEED: " + seed);
        System.out.println("# GENERATIONS: " + numGenerations);

        System.out.println("GENERATION: " + generationNum);
        generation.print();
    }
}
