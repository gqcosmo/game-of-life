package app;
import core.Game;

public class Main {
    public static void main(String[] args) {
        final int N = 3;
        final int M = 3;
        final long SEED = 5;
        final int ITERS = 1;

        Game game = new Game(N, M, SEED, ITERS);
        game.printConfig();
        System.out.println("\n\n");
        game.run();
    }
}
