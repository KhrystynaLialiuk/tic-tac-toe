package com.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Field {

    private static final Color VICTORY_COLOR = new Color(152,230,152);
    private static final Color DEFEAT_COLOR = new Color(255, 128, 128);
    private static final String FRAME_TITLE = "Tic-Tac-Toe Game!";
    private JFrame frame;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private int format;


    public Field(int format) {

        this.format = format;
        frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 370);

        for (int i = 0; i < format * format; i++){
            JButton button = new JButton();
            buttonList.add(button);
            frame.add(button);
        }

        frame.setLayout(new GridLayout(format, format));
        frame.setVisible(true);
    }

    public boolean areThereEnabledButtons() {
        boolean buttonEnabled = false;
        for (JButton button : buttonList) {
            if (button.isEnabled()) {
                buttonEnabled = true;
            }
        }
        return buttonEnabled;
    }

    public void changeButtonsColor(ArrayList<JButton> buttons, String symbol) {
        for (JButton button : buttons) {
            if (symbol == "X") {
                button.setBackground(VICTORY_COLOR);
            } else {
                button.setBackground(DEFEAT_COLOR);
            }
        }
    }

    public int getFormat() {
        return format;
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public JFrame getFrame() {
        return frame;
    }
}
