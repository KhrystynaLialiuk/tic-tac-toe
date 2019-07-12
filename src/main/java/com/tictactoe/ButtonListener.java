package com.tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private static final String PLAYER_WON_ROUND = "Yeeah! You have won this round!";
    private static final String COMPUTER_WON_ROUND = "Oops! Computer has won this round!";
    private static final String DRAW_IN_ROUND = "Draw in this round!";
    private Field field;
    private Player player;
    private Computer computer;
    private Analyzer analyzer;

    public ButtonListener(Field field, Player player, Computer computer, Analyzer analyzer) {
        this.field = field;
        this.player = player;
        this.computer = computer;
        this.analyzer = analyzer;
    }

    public void actionPerformed (ActionEvent e){
        JButton button = (JButton) e.getSource();
        player.makeMove(button);
        if (analyzer.somebodyHasWon(field, "X")) {
            player.setPlayerScore(player.getPlayerScore() + 1);
            JOptionPane.showMessageDialog(null, PLAYER_WON_ROUND);
            analyzer.continueGame(player, computer, analyzer, field);
        } else if (field.areThereEnabledButtons()) {
            computer.makeComputerMove(field);
            if (analyzer.somebodyHasWon(field, "O")) {
                computer.setComputerScore(computer.getComputerScore() + 1);
                JOptionPane.showMessageDialog(null, COMPUTER_WON_ROUND);
                analyzer.continueGame(player, computer, analyzer, field);
            }
        } else {
            JOptionPane.showMessageDialog(null, DRAW_IN_ROUND);
            analyzer.continueGame(player, computer, analyzer, field);
        }
    }
}
