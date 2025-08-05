package app;
import core.Game;

public class Main {
    public static void main(String[] args) {
        final int N = 3;
        final int M = 3;
        final int SEED = 1000;
        final int ITERS = 10;

        Game game = new Game(N, M, SEED, ITERS);
        game.printConfig();
        System.out.println("\n\n");
        game.run();
    }
}
