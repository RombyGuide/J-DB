package com.devind.database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Пример получения данных из базы данных
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.testDatabase();
    }

    private void testDatabase() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(url, "root", "root");
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    String str = rs.getString("email") + "," + " name" + ":" + rs.getString("name") + "," + " age" + ":" + rs.getInt("age");
                    printString(str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printString(String str) {
        System.out.println("email:" + str);
    }
}
