package app;
import core.Game;

public class Main {
    public static void main(String[] args) {
        final int ROWS = 5;
        final int COLUMNS = 10;
        final long SEED = System.currentTimeMillis();
        final int ITERS = 20;

        Game game = new Game(ROWS, COLUMNS, SEED, ITERS);
        game.printConfig();
        System.out.println("\n\n");
        game.run();
    }
}
