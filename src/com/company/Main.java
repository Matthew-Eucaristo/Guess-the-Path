package com.company;

import javax.swing.*;

public class Main {
    public static JFrame frameConnector;
    public static String stageTypeConnector;
    // Main Method
    public static void main(String[] args) {
        // frame init
        MainMenu mainMenu = new MainMenu(true);
        frameConnector = mainMenu;
    }

}
