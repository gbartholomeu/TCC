/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ronyjack
 */
public class DAO {

    private static Connection con = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static ResultSet selectFromDatabase(String sql, Object... args) {
        try {
            con = DbConnection.getConnection();
            stmt = con.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] != null) {
                        if (args[i] instanceof String) {
                            stmt.setString((i + 1), String.valueOf(args[i]));
                        } else if (args[i] instanceof Integer) {
                            stmt.setInt((i + 1), Integer.parseInt(String.valueOf(args[i])));
                        } else if (args[i] instanceof Date) {
                            stmt.setDate((i + 1), Date.valueOf(String.valueOf(args[i])));
                        } else if (args[i] instanceof byte[]) {
                            stmt.setBytes((i + 1), (byte[]) args[i]);
                        }
                    }
                }
            }

            printQuery();
            rs = stmt.executeQuery();
        } catch (Exception ex) {
            System.out.println("Failed to perform select from database: " + ex);
        }
        return rs;
    }

    public static int insertIntoDatabase(String sql, Object... args) {
        int updateReturn = 0;
        try {
            con = DbConnection.getConnection();
            stmt = con.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] != null) {
                        if (args[i] instanceof String) {
                            stmt.setString((i + 1), String.valueOf(args[i]));
                        } else if (args[i] instanceof Integer) {
                            stmt.setInt((i + 1), Integer.parseInt(String.valueOf(args[i])));
                        } else if (args[i] instanceof Date) {
                            stmt.setDate((i + 1), Date.valueOf(String.valueOf(args[i])));
                        } else if (args[i] instanceof byte[]) {
                            stmt.setBytes((i + 1), (byte[]) args[i]);
                        }
                    }
                }
            }

            printQuery();
            updateReturn = stmt.executeUpdate();
        } catch (SQLException | NumberFormatException ex) {
            System.out.println("Failed to perform insert into database: " + ex);
        }
        return updateReturn;
    }

    private static void printQuery() {
        System.out.println(stmt.toString());
    }
}
