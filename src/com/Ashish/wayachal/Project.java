package com.Ashish.wayachal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setTitle("UNIVERSITY MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1540, 850);
        setLocationRelativeTo(null); // Centers window

        // Set Window Icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/index1.jpg"));
        setIconImage(icon.getImage());

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/index.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(i2));
        setContentPane(background);

        // --- MENU BAR ---
        JMenuBar mb = new JMenuBar();
        mb.setBackground(Color.BLACK);

        // Add Menus
        addMenu(mb, "New Information", Color.BLUE, "New Faculty Information", "New Student Information");
        addMenu(mb, "View Details", Color.RED, "View Faculty Details", "View Student Details");
        addMenu(mb, "Apply Leave", Color.BLUE, "Faculty Leave", "Student Leave");
        addMenu(mb, "Leave Details", Color.RED, "Faculty Leave", "Student Leave");
        addMenu(mb, "Examination", Color.BLUE, "Examination Results", "Enter Marks");
        addMenu(mb, "Update Details", Color.RED, "Update Faculty Details", "Update Student Details");
        addMenu(mb, "Fee Details", Color.BLUE, "Fee Structure", "Student Fee Form");

        // --- UTILITY MENU ---
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        JMenuItem notepad = createMenuItem("Notepad");
        JMenuItem calc = createMenuItem("Calculator");
        utility.add(notepad);
        utility.add(calc);
        mb.add(utility);

        // --- EXIT MENU ---
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        JMenuItem ex = createMenuItem("Exit");
        exit.add(ex);
        mb.add(exit);

        setJMenuBar(mb);
        setVisible(true);
    }

    // Helper Method to Add Menus
    private void addMenu(JMenuBar mb, String title, Color color, String... items) {
        JMenu menu = new JMenu(title);
        menu.setForeground(color);
        for (String item : items) {
            menu.add(createMenuItem(item));
        }
        mb.add(menu);
    }

    // Helper Method to Create Menu Items
    private JMenuItem createMenuItem(String name) {
        JMenuItem item = new JMenuItem(name);
        item.setBackground(Color.WHITE);
        item.setFont(new Font("Arial", Font.PLAIN, 14));
        item.addActionListener(this);
        return item;
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        switch (msg) {
            case "Exit":
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;

            case "Notepad":
                openApplication("notepad.exe");
                break;

            case "Calculator":
                openApplication("calc.exe");
                break;
        }
    }

    // Opens External Applications
    private void openApplication(String appName) {
        try {
            new ProcessBuilder(appName).start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + appName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
