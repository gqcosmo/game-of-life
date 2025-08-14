package controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.*;
import view.*;


public class Controller {
    private Timer timer;
    private Window window;
    private Generation generation;
    private int delay = 500;
    private int targetGenerations;

    public Controller(Generation generation, Window window) {
        this.generation = generation;
        this.window = window;
    }

    public void step() {
        generation = generation.next();
        window.setGrid(generation.getGrid());
        window.updateStats(generation.getGenNum(), generation.getAlive());
    }

    public void start(int numGenerations) {
        targetGenerations = numGenerations;
        timer = new Timer(delay, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (targetGenerations > 0 && count >= targetGenerations) {
                    timer.stop();
                    return;
                } else if (generation.getAlive() == 0) {
                    timer.stop();
                    return;
                }
                step();
                count++;
            }
        });
        timer.start();
    }
}
