package com.company;

import javax.swing.*;

public class Main {
    // For Score and Health
    private static int score = 0; // init for score
    private static int life = 3; // init for life
    private static JFrame frameConnector;
    private static String stageTypeConnector;

    // Main Method
    public static void main(String[] args) {
        // frame init
        MainMenu mainMenu = new MainMenu(true);
        setFrameConnector(mainMenu);
    }

    // Setter Getter
    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Main.score = score;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        Main.life = life;
    }

    public static JFrame getFrameConnector() {
        return frameConnector;
    }

    public static void setFrameConnector(JFrame frameConnector) {
        Main.frameConnector = frameConnector;
    }

    public static String getStageTypeConnector() {
        return stageTypeConnector;
    }

    public static void setStageTypeConnector(String stageTypeConnector) {
        Main.stageTypeConnector = stageTypeConnector;
    }
}
