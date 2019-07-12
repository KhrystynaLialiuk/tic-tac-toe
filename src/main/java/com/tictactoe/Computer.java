package com.tictactoe;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Computer {

    private static final String COMPUTER_SYMBOL = "O";
    private int computerScore = 0;
    private Random randomize = new Random();

    public void makeComputerMove(Field field){

        int choice;

        ArrayList<JButton> availableButtons = new ArrayList<>();
        for (JButton button : field.getButtonList()) {
            if (button.isEnabled()) {
                availableButtons.add(button);
            }
        }
        choice = randomize.nextInt(availableButtons.size());
        availableButtons.get(choice).setText(COMPUTER_SYMBOL);
        availableButtons.get(choice).setEnabled(false);
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }
}
