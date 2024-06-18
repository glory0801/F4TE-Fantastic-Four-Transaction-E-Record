/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Setting;

/**
 *
 * @author glory
 */
public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            String url = "jdbc:sqlite:" + Setting.getDefault().getDbfile();
            System.out.println("URL:" + url);
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(url);
            } catch (ClassNotFoundException | SQLException e) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }
}