package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainMenu {
    JPanel panelMain;
    private JButton playButton;
    private JButton exitButton;
    protected JComboBox comboBox1;
    // For different type
    public String stageType;

    private JFrame connector;


    public MainMenu() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thanks for using this Application");
                System.exit(0);
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.stageTypeConnector = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                JFrame stageFrame = new JFrame("Stage");
                stageFrame.setContentPane(new Stage().panelMain);
                stageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                stageFrame.pack();
                stageFrame.setVisible(true);
                Main.frameConnector.setVisible(false);
                
            }
        });
    }

}
