package view;
import javax.swing.*;
import java.awt.*;
import model.Grid;

public class GamePanel extends JPanel {
    private Grid grid;

    public GamePanel(Grid grid) {
        this.grid = grid;
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int rows = grid.getRows();
        int cols = grid.getColumns();
        int cellSize = Math.min(getWidth() / cols, getHeight() / rows);

        int gridWidth = cellSize * cols;
        int gridHeight = cellSize * rows;
        int xOffset = (getWidth() - gridWidth) / 2;
        int yOffset = (getHeight() - gridHeight) / 2;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                g.setColor(grid.at(i, j) == 'O' ? Color.yellow : Color.lightGray);
                g.fillRect(xOffset + j * cellSize, yOffset + i * cellSize, cellSize, cellSize);

                g.setColor(Color.BLACK);
                g.drawRect(xOffset + j * cellSize, yOffset + i * cellSize, cellSize, cellSize);
            }
        }
    }

    protected void setGrid(Grid grid) {
        this.grid = grid;
        repaint();
    }
}
