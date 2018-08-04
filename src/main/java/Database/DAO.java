/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Constantes.Expressions;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author gbartholomeu
 */
public class DAO {

    private static Connection con = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    private final static Logger LOGGER = Logger.getLogger(DAO.class.getName());

    public static Object selectFromDatabase(String sql, Object... args) {
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
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder(Expressions.DAO.SELECT_BASE_EX.getExpression()).append(ex).toString());
            return ex.toString();
        }
        return (ResultSet) rs;
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
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder(Expressions.DAO.INSERT_BASE_EX.getExpression()).append(ex).toString());
        }
        return updateReturn;
    }

    public static int updateRegisterDatabase(String sql, Object... args) {
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
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder(Expressions.DAO.UPDATE_BASE_EX.getExpression()).append(ex).toString());
        }
        return updateReturn;
    }

    public static int deleteFromDatabase(String sql, Object... args) {
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
        } catch (SQLException ex) {
            LOGGER.info(new StringBuilder(Expressions.DAO.DELETE_BASE_EX.getExpression()).append(ex).toString());
        }
        return updateReturn;
    }

    private static void printQuery() {
        System.out.println(stmt.toString());
    }
}
