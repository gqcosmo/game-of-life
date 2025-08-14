package app;
import core.Game;

public class Main {
    public static void main(String[] args) {
        final int ROWS = 40;
        final int COLUMNS = 40;
        final long SEED = System.currentTimeMillis();
        final int ITERS = 1000;

        Game game = new Game(ROWS, COLUMNS, SEED, ITERS);
        game.run();
    }
}