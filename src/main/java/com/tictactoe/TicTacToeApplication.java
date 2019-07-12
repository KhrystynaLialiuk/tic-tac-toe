package com.tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToeApplication {

    public static void main(String[] args) {

        String numberOfRounds = JOptionPane.showInputDialog(null, "Please enter number of rounds:",
                "Game settings", JOptionPane.PLAIN_MESSAGE);
        String format = JOptionPane.showInputDialog(null, "Please enter preferred number of columns/rows:",
                "Format of the game", JOptionPane.PLAIN_MESSAGE);

        Player player = new Player();
        Computer computer = new Computer();
        Analyzer analyzer = new Analyzer(Integer.valueOf(numberOfRounds));
        runGameRound(player, computer, analyzer, Integer.valueOf(format));
    }

    static void runGameRound(Player player, Computer computer, Analyzer analyzer, int format) {

        Field field = new Field(format);

        for (Component component : field.getButtonList()) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(new ButtonListener(field, player, computer, analyzer));
            }
        }
    }
}
