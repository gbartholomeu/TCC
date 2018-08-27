/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Constantes.Expressions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

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
    public static Connection con;
    public static String urlstring;

    public static Connection getConnection() throws SQLException, ClassNotFoundException, Exception {
        try {
            if ("".equalsIgnoreCase(getUrl())) {
                readTxt();
            }
            Class.forName(getDriverName());
            try {
                setCon(DriverManager.getConnection(getUrl(), getUsername(), getPassword()));
            } catch (SQLException sqlEx) {
                throw new SQLException(Expressions.CONNECTION.DATABASE_CONNECTION_EX.getExpression() + sqlEx.getMessage());
            }
        } catch (ClassNotFoundException clnfEx) {
            throw new ClassNotFoundException(Expressions.CONNECTION.DRIVER_CONNECTION_EX.getExpression() + clnfEx.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return getCon();
    }

    private static void readTxt() throws Exception {
        String line = null;
        BufferedReader bufferedReader = null;
        try {
            File configFile = new File("src/main/java/Database/Config.dmdat");
            if (configFile.exists()) {
                FileReader fileReader = new FileReader(configFile);
                bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains("serverip##")) {
                        String urlTxt = line.replace("serverip##", "");
                        setUrl("jdbc:mysql://" + urlTxt + getDBSettings());
                    } else if (line.contains("serverusername##")) {
                        String usernameTxt = line.replace("serverusername##", "");
                        setUsername(usernameTxt);
                    } else if (line.contains("serverpass##")) {
                        String passTxt = line.replace("serverpass##", "");
                        setPassword(passTxt);
                    }
                }
                bufferedReader.close();
            } else {
                throw new FileNotFoundException("Arquivo de configuração não encontrado.");
            }
        } catch (IOException ex) {
            throw new IOException(Expressions.CONNECTION.CONFIG_FILE_EX.getExpression() + ex.getMessage());
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
