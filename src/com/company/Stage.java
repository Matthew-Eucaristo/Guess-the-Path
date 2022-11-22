package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Stage {
    public Stage() {
        // for initializaton
        // set top-right text
        stageType.setText(Main.stageTypeConnector);

        // set jlabel icon
        Random randomizer = new Random();
        int randomImageFileName = randomizer.nextInt(Objects.requireNonNull(new File("src/com/company/soal/gambar").list()).length);
        gambar.setIcon(new ImageIcon(String.format("src/com/company/soal/gambar/%d.png",randomImageFileName)));

        // Listener
        submitButton.addActionListener(e -> {
            // Submit button
            if (checkAnswer(textField1.getText().toLowerCase())) {
                // correct
                System.out.println("Correct!");
            } else {
                // incorrect
                System.out.println("Incorrect!");
            }
        });
    }

    private boolean checkAnswer(String answer) {
        // TODO: 11/22/2022 Connect ke algorithm buat cek jawaban
        return true;
    }
    private JTextField textField1;
    private JButton submitButton;
    JPanel panelMain;
    private JLabel stageType;
    private JLabel gambar;


}
