package com.Ashish.wayachal;

import java.sql.*;

public class Conn {

    Connection con;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_db", "root", "Ashish@99");
            s = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }
}
