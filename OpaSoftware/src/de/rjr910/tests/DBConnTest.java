package de.rjr910.tests;

import java.sql.*;
public class DBConnTest {
    public static void main(String[] a)
            throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
            getConnection("jdbc:h2:~/DB/test", "sa", "");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM DEUTSCH");
        
        while(rs.next()){
        	System.out.println(rs.getString("ANSWER1"));
        }
        
        conn.close();
    }
}