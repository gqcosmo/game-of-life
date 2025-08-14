package view;
import javax.swing.*;
import java.awt.*;
import model.Generation;

public class StatsPanel extends JPanel {
    private JLabel generationLabel;
    private JLabel aliveLabel;

    public StatsPanel(int currGen, int currAlive) {
        Font font = new Font("Courier", Font.BOLD, 16);

        generationLabel = new JLabel("Current Generation: " + currGen);
        generationLabel.setFont(font);
        add(generationLabel);

        add(Box.createHorizontalStrut(25));

        aliveLabel = new JLabel("Alive: " + currAlive);
        aliveLabel.setFont(font);
        add(aliveLabel);
    }

    protected void updateStats(int currGen, int currAlive) {
        generationLabel.setText("Current Generation: " + currGen);
        aliveLabel.setText("Alive: " + currAlive);
    }
}
