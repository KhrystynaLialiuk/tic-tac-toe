package com.tictactoe;

import javax.swing.*;
import java.util.ArrayList;

import static com.tictactoe.TicTacToeApplication.main;
import static com.tictactoe.TicTacToeApplication.runGameRound;

public class Analyzer {

    private static final String RESULT_WINDOW_TITLE = "Game result";
    private static final String PLAYER_WON_GAME = "Congratulations! You have won this game!";
    private static final String COMPUTER_WON_GAME = "Unfortunately this time you have lost the game.";
    private static final String DRAW_IN_GAME = "It is a draw!";
    private int preferredNumberOfRounds;
    private int numberOfRoundsPlayed = 0;
    private boolean columnCrossed = false;
    private boolean rowCrossed = false;
    private boolean diagonal1Crossed = false;
    private boolean diagonal2Crossed = false;
    private ArrayList<JButton> buttonsToColor = new ArrayList<>();

    public Analyzer(int preferredNumberOfRounds) {
        this.preferredNumberOfRounds = preferredNumberOfRounds;
    }

    public boolean somebodyHasWon(Field field, String symbol) {

        int columnsAmount = field.getFormat();

        for (int c = 0; c < columnsAmount; c++){
            buttonsToColor.clear();
            for (int r = 0; r < (columnsAmount * columnsAmount); r += columnsAmount) {
                if (field.getButtonList().get(c + r).getText().equals(symbol)) {
                    buttonsToColor.add(field.getButtonList().get(c + r));
                }
            }
            if (buttonsToColor.size() == columnsAmount) {
                columnCrossed = true;
                field.changeButtonsColor(buttonsToColor, symbol);
            }
        }

        for (int row = 0; row < (columnsAmount * columnsAmount); row += columnsAmount) {
            buttonsToColor.clear();
            for (int column = 0; column < columnsAmount; column++) {
                if (field.getButtonList().get(row + column).getText().equals(symbol)) {
                    buttonsToColor.add(field.getButtonList().get(row + column));
                }
            }
            if (buttonsToColor.size() == columnsAmount) {
                rowCrossed = true;
                field.changeButtonsColor(buttonsToColor, symbol);
            }
        }

        buttonsToColor.clear();
        for (int diagonal1 = 0; diagonal1 < (columnsAmount * columnsAmount); diagonal1 += columnsAmount + 1) {
            if (field.getButtonList().get(diagonal1).getText().equals(symbol)) {
                buttonsToColor.add(field.getButtonList().get(diagonal1));
            }
        }
        if (buttonsToColor.size() == columnsAmount) {
            diagonal1Crossed = true;
            field.changeButtonsColor(buttonsToColor, symbol);
        }

        buttonsToColor.clear();
        for (int diagonal2 = columnsAmount - 1; diagonal2 <= ((columnsAmount - 1) * columnsAmount); diagonal2 += columnsAmount - 1) {
            if (field.getButtonList().get(diagonal2).getText().equals(symbol)) {
                buttonsToColor.add(field.getButtonList().get(diagonal2));
            }
        }
        if (buttonsToColor.size() == columnsAmount) {
            diagonal2Crossed = true;
            field.changeButtonsColor(buttonsToColor, symbol);
        }

        return (columnCrossed || rowCrossed || diagonal1Crossed || diagonal2Crossed);
    }

    public void continueGame(Player player, Computer computer, Analyzer analyzer, Field field) {
        numberOfRoundsPlayed++;
        if (numberOfRoundsPlayed < preferredNumberOfRounds) {
            columnCrossed = false;
            rowCrossed = false;
            diagonal2Crossed = false;
            diagonal1Crossed = false;
            runGameRound(player, computer, analyzer, field.getFormat());
            field.getFrame().dispose();
        } else {
            showGameResults(player, computer, field);
        }
    }

    public void showGameResults(Player player, Computer computer, Field field) {
        String result;
        if (player.getPlayerScore() > computer.getComputerScore()) {
            result = PLAYER_WON_GAME;
        } else if (player.getPlayerScore() < computer.getComputerScore()) {
            result = COMPUTER_WON_GAME;
        } else {
            result = DRAW_IN_GAME;
        }

        int answer = JOptionPane.showConfirmDialog(null, "Your score is: " +
                        player.getPlayerScore() + "\n" + "Computer score is: " + computer.getComputerScore() +
                        "\n\n" + result + "\n" + "Let's play again!", RESULT_WINDOW_TITLE, JOptionPane.YES_NO_OPTION);
        switch (answer) {
            case JOptionPane.YES_OPTION:
                field.getFrame().dispose();
                main(null);
                break;
            case JOptionPane.NO_OPTION:
                field.getFrame().dispose();
                break;
        }
    }
}
