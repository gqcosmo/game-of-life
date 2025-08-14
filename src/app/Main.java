package app;
import core.Game;

public class Main {
    public static void main(String[] args) {
        final int ROWS = 350;
        final int COLUMNS = 350;
        final long SEED = System.currentTimeMillis();
        final int ITERS = 1000;

        Game game = new Game(ROWS, COLUMNS, SEED, ITERS);
        game.run();
    }
}