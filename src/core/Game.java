package core;
import java.util.Random;
import model.*;
import controller.Controller;
import view.Window;

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

        Generation currentGen = new Generation(grid, 0);
        Controller controller = new Controller(currentGen, new Window(currentGen));
        controller.start(numGenerations);
    }
}
