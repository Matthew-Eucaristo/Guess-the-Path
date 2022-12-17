package com.company;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainMenu extends JFrame {
    JPanel panelMain;
    private JLabel backgroundImageLabel;
    private JButton playButton;
    private JButton exitButton;
    protected JComboBox comboBox1;
    public static Clip clip;



    public MainMenu(boolean visibility) {
        // Initializer
        setIconImage(new ImageIcon("src/com/company/assets/images/logo.png").getImage()); // for icon
        setContentPane(panelMain);
        setTitle("Guess The Path!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(800, 680); // still need this so that if minimized it's not ugly
        setLocationRelativeTo(null);
        setVisible(visibility);
        getRootPane().setDefaultButton(playButton); // to set play button to default, so 'enter' will start at play

        // listener for window closing
        addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                clip.close();
            }
        });

        // set background music
        music();

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


    private void music() {
        /*
         The assets used for the music is
         Different Heaven - Safe And Sound [NCS Release]
         https://www.youtube.com/watch?v=13ARO0HDZsQ
         All credits belong to its rightful owner.
        */
        try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src/com/company/assets/music/music.wav"));
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            clip.start();
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
