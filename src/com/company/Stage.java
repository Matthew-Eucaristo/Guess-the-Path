package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Stage {
    public Stage() {
        // for initializaton
        // set top-right text
        stageType.setText(Main.stageTypeConnector);

        // set jlabel icon
        Random randomizer = new Random();
        int randomImageFileName = randomizer.nextInt(1);
        gambar.setIcon(new ImageIcon(String.format("src/com/company/soal/gambar/%d.png",randomImageFileName)));

        // Listener
        submitButton.addActionListener(e -> {
            // Submit button
        });
    }

    private JTextField textField1;
    private JButton submitButton;
    JPanel panelMain;
    private JLabel stageType;
}
