/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gbartholomeu
 */
public class DbConnection {

    public static String url = "";
    public static String username = "";
    public static String password = "";
    public static String DBSettings = "?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false";
    public static String driverName = "com.mysql.cj.jdbc.Driver";
    //public static String url = "jdbc:mysql://cristianweb.com.br:3306/crist609_database_management?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false";
    //public static String username = "crist609_root";
    //public static String password = "281096";

//    public static String url = "jdbc:mysql://localhost:3306/database_management?useTimezone=true&serverTimezone=UTC&useSSL=false";
//    public static String driverName = "com.mysql.cj.jdbc.Driver";
//    public static String username = "root";
//    public static String password = "281096";
    public static Connection con;
    public static String urlstring;

    public static Connection getConnection() {
        try {
            if ("".equalsIgnoreCase(getUrl())) {
                readTxt();
            }
            Class.forName(getDriverName());
            try {
                setCon(DriverManager.getConnection(getUrl(), getUsername(), getPassword()));
            } catch (SQLException sqlEx) {
                System.out.println("Failed to create the database connection." + sqlEx);
            }
        } catch (ClassNotFoundException clnfEx) {
            System.out.println("Driver not found." + clnfEx);
        }
        return getCon();
    }

    private static void readTxt() {
        String line = null;
        BufferedReader bufferedReader = null;
        try {
            if (!new File("src/main/java/Database/Config.dmdat").exists()) {
                setUrl("jdbc:mysql://cristianweb.com.br:3306/crist609_database_management?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false");
                setUsername("crist609_root");
                setPassword("281096");
            } else {
                FileReader fileReader = new FileReader(new File("src/main/java/Database/Config.dmdat"));
                bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains("serverip##")) {
                        String urlTxt = line.replace("serverip##", "");
                        setUrl("jdbc:mysql://" + urlTxt + getDBSettings());
                        System.out.println(line);
                    } else if (line.contains("serverusername##")) {
                        String usernameTxt = line.replace("serverusername##", "");
                        setUsername(usernameTxt);
                        username = usernameTxt;
                        System.out.println(usernameTxt);
                    } else if (line.contains("serverpass##")) {
                        String passTxt = line.replace("serverpass##", "");
                        setPassword(passTxt);
                        System.out.println(line);
                    }
                }
                bufferedReader.close();
            }

        } catch (IOException ex) {
            System.out.println("Error reading file Config.txt");
        }
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DbConnection.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DbConnection.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DbConnection.password = password;
    }

    public static String getDriverName() {
        return driverName;
    }

    public static void setDriverName(String driverName) {
        DbConnection.driverName = driverName;
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DbConnection.con = con;
    }

    public static String getUrlstring() {
        return urlstring;
    }

    public static void setUrlstring(String urlstring) {
        DbConnection.urlstring = urlstring;
    }

    public static String getDBSettings() {
        return DBSettings;
    }

    public static void setDBSettings(String DBSettings) {
        DbConnection.DBSettings = DBSettings;
    }
}
