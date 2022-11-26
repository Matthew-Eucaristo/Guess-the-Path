package com.company;

import javax.swing.*;
import java.util.Objects;

public class MainMenu extends JFrame {
    JPanel panelMain;
    private JButton playButton;
    private JButton exitButton;
    protected JComboBox comboBox1;

    public MainMenu(boolean visibility) {
        // Initializer
        setContentPane(panelMain);
        setTitle("Guess The path!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(visibility);

        // Event handler
        exitButton.addActionListener(e -> {
            System.out.println("Thanks for using this Application ~UWU~");
            System.exit(0);
        });
        playButton.addActionListener(e -> {
            Main.stageTypeConnector = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            Stage stage = new Stage(true);
            Main.frameConnector.setVisible(false);

        });
    }

}
