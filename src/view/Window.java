package view;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import model.Generation;
import model.Grid;

public class Window extends JFrame {
    StatsPanel stats;
    GamePanel game;

    public Window(Generation generation) {
        super("GAME OF LIFE");
        stats = new StatsPanel(0, generation.getAlive());
        game = new GamePanel(generation.getGrid());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel container = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        container.add(stats, gbc);

        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(game, gbc);

        add(container);
        setVisible(true);
    }

    public void setGrid(Grid grid) {
        game.setGrid(grid);
    }

    public void updateStats(int currGen, int currAlive) {
        stats.updateStats(currGen, currAlive);
    }
}
