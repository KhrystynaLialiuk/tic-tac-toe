package com.tictactoe;

import javax.swing.*;

public class Player {

    private static final String PLAYER_SYMBOL = "X";
    private int playerScore = 0;

    public void makeMove(JButton button) {
        button.setText(PLAYER_SYMBOL);
        button.setEnabled(false);
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
