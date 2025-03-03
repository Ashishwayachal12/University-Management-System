package com.Ashish.wayachal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, cancel;
    JTextField tfUsername;
    JPasswordField tfPassword;

    Login() {
        setTitle("UNIVERSITY MANAGEMENT SYSTEM");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/index1.jpg"));
        setIconImage(icon.getImage());
        setResizable(false);

        getContentPane().setBackground(new Color(240, 248, 255)); // Light Blue
        setLayout(null);

        JLabel heading = new JLabel("LOGIN PORTAL");
        heading.setBounds(140, 10, 300, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 24));
        heading.setForeground(new Color(0, 51, 102));
        add(heading);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(40, 60, 100, 20);
        lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 60, 150, 25);
        tfUsername.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 100, 100, 20);
        lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 100, 150, 25);
        tfPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(tfPassword);

        login = new JButton("Login");
        login.setBounds(40, 160, 120, 35);
        login.setBackground(new Color(0, 102, 204));
        login.setForeground(Color.white);
        login.setFont(new Font("SansSerif", Font.BOLD, 15));
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createRaisedBevelBorder());
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 160, 120, 35);
        cancel.setBackground(new Color(204, 0, 0));
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("SansSerif", Font.BOLD, 15));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createRaisedBevelBorder());
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 40, 150, 150);
        add(image);

        setSize(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfUsername.getText();
            String password = new String(tfPassword.getPassword());

            if (authenticateUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    private boolean authenticateUser(String username, String password) {
        boolean isValid = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_db", "root", "password");
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            isValid = rs.next();
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Error!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return isValid;
    }

    public static void main(String[] args) {
        new Login();
    }
}
