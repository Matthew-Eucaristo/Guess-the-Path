package com.company;

import javax.swing.*;

public class Main {
    // For Score and Health
    public static int score = 0; // init for score
    public static int life = 3; // init for life
    public static JFrame frameConnector;
    public static String stageTypeConnector;
    // Main Method
    public static void main(String[] args) {
        // frame init
        MainMenu mainMenu = new MainMenu(true);
        frameConnector = mainMenu;
    }

}
