/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gbartholomeu
 */
public class DbConnection {

    public static String url = "jdbc:mysql://cristianweb.com.br:3306/crist609_database_management?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String driverName = "com.mysql.cj.jdbc.Driver";
    public static String username = "crist609_root";
    public static String password = "281096";
//    public static String url = "jdbc:mysql://localhost:3306/database_management?useTimezone=true&serverTimezone=UTC&useSSL=false";
//    public static String driverName = "com.mysql.cj.jdbc.Driver";
//    public static String username = "root";
//    public static String password = "281096";
    public static Connection con;
    public static String urlstring;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException sqlEx) {
                System.out.println("Failed to create the database connection." + sqlEx);
            }
        } catch (ClassNotFoundException clnfEx) {
            System.out.println("Driver not found." + clnfEx);
        }
        return con;
    }
}
