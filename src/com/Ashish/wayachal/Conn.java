package com.Ashish.wayachal;


import java.sql.*;

public class Conn {

    Connection c;
    Statement s;


    public  Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///university_db","root","Ashish@99");
            s=c.createStatement();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}


