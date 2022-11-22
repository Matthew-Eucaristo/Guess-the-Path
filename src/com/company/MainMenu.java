package com.company;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class MainMenu {
    JPanel panelMain;
    private JButton playButton;
    private JButton exitButton;
    protected JComboBox comboBox1;

    public MainMenu() {
        exitButton.addActionListener(e -> {
            System.out.println("Thanks for using this Application ~UWU~");
            System.exit(0);
        });
        playButton.addActionListener(e -> {
            Main.stageTypeConnector = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            JFrame stageFrame = new JFrame("Stage");
            stageFrame.setContentPane(new Stage().panelMain);
            stageFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            stageFrame.pack();
            stageFrame.setLocationRelativeTo(null);
            stageFrame.setVisible(true);
            stageFrame.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    Main.frameConnector.setVisible(true);
                }
            });
            Main.frameConnector.setVisible(false);

        });
    }

}
