package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class Losing extends JFrame{
    private JPanel panelMain;
    private JLabel backImageLabel;
    private Clip losingClip;

    public Losing(boolean visibility) {
        // for initialization
        setIconImage(new ImageIcon("src/com/company/assets/images/logo.png").getImage()); // for icon
        setContentPane(panelMain);
        setTitle("You Lose ! Try Again ?");
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
        setLocationRelativeTo(null);
        setVisible(visibility);

        // for background
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        backImageLabel.setPreferredSize(screenSize);
        backImageLabel.setHorizontalAlignment(JLabel.CENTER);
        backImageLabel.setVerticalAlignment(JLabel.CENTER);

        // reset health and score
        Main.life = 3;
        Main.score = 0;

        // pause music and start losing music
        long clipTimePosition = MainMenu.clip.getMicrosecondPosition();
        MainMenu.clip.stop();
        music();

        // add mouse listener and key listener for closing this window
        panelMain.addComponentListener(new ComponentAdapter() {
        });
        panelMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                closeThisWindow(clipTimePosition);
            }
        });
        panelMain.requestFocus(); // request focus
        panelMain.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    closeThisWindow(clipTimePosition);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }

    private void music() {
        /*
        The assets used for the msuic is
        "Death of Kings" Kevin MacLeod (incompetech.com)
        Licensed under Creative Commons: By Attribution 4.0 License
        http://creativecommons.org/licenses/by/4.0/
        All credits belong to its rightful owner
         */
        try {
            losingClip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src/com/company/assets/music/Death of Kings.wav"));
            losingClip.open(inputStream);
            losingClip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl = (FloatControl) losingClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(5f);
            losingClip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);

        }
    }

    private void closeThisWindow(long clipTimePosition){
        // for closing and returning to main menu

        // stop lose music
        losingClip.stop();

        // resume music
        MainMenu.clip.setMicrosecondPosition(clipTimePosition);
        MainMenu.clip.start();

        // go to main menu
        Main.frameConnector.setVisible(true);
        dispose();

    }
}
