package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        setTitle("UNIVERSITY MANAGEMENT SYSTEM");

        // Set application icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/index1.jpg"));
        setIconImage(icon.getImage());

        // Load splash image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/index.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 700);
        add(image);

        // Frame settings
        setLayout(null);
        setUndecorated(true); // Removes window borders
        setSize(1000, 700);
        setLocationRelativeTo(null); // Centers the frame
        setVisible(true);

        // Start animation
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Open next frame
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
