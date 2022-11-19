package com.company;

import javax.swing.*;

public class Stage {
    public Stage() {
        // for initializaton
        stageType.setText(Main.stageTypeConnector);
    }

    private JTextField textField1;
    private JButton submitButton;
    JPanel panelMain;
    private JLabel stageType;
}
