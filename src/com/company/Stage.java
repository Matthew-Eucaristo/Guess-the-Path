package com.company;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Objects;
import java.util.Random;

public class Stage extends JFrame{
    private JTextField textField1;
    private JButton submitButton;
    JPanel panelMain;
    private JLabel stageType;
    private JLabel gambar;

    public Stage(boolean visibility) {
        // for initialization
        setContentPane(panelMain);
        setTitle("Stage");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setSize(550,400);
        setLocationRelativeTo(null);
        setVisible(visibility);
        addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                Main.frameConnector.setVisible(true);
            }
        });

        // set top-right text
        stageType.setText(Main.stageTypeConnector);

        // set jlabel icon
        Random randomizer = new Random();
        int randomImageFileName = randomizer.nextInt(Objects.requireNonNull(new File("src/com/company/soal/gambar").list()).length);
        gambar.setIcon(new ImageIcon(String.format("src/com/company/soal/gambar/%d.png",randomImageFileName)));

        // clear text
        gambar.setText("");

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



}
