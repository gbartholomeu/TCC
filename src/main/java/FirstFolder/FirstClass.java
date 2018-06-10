/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstFolder;

import Database.DbConnection;
import java.sql.SQLException;

/**
 *
 * @author ronyjack
 */
public class FirstClass {

    public static void main(String[] args) throws SQLException {
        System.out.println("HELLO WORLD");
        System.out.println(DbConnection.getConnection().isValid(1));
    }
}
