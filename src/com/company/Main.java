package com.company;

import javax.swing.*;

public class Main {
    public static JFrame frameConnector;
    public static String stageTypeConnector;
    // Main Method
    public static void main(String[] args) {
        // frame init
        JFrame mainMenuFrame = new JFrame("Guess the Path");

        // frame start function
        mainMenuFrame.setContentPane(new MainMenu().panelMain);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.pack();
        mainMenuFrame.setLocationRelativeTo(null);

        // Toggle starting menu
        mainMenuFrame.setVisible(true);

        frameConnector = mainMenuFrame;
    }

}
