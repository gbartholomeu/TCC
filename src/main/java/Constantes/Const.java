/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constantes;

/**
 *
 * @author gbartholomeu
 */
public class Const {

    public enum SQL {
        SELECT_USER(
                "SELECT 1 QTD, \n"
                + "       saltpass SALT,"
                + "       interations INTERA, \n"
                + "       keylength KEYL, \n"
                + "       userpassword PASS \n,"
                + "       isAdmin  \n"
                + "FROM application_user \n"
                + "WHERE username = ?;"),
        SELECT_ALL_DICTIONARY(
                "SELECT * "
                + "FROM dictionary;"),
        SELECT_ALL_DICTIONARY_HISTORY(
                "SELECT * \n"
                + "FROM dictionary_history \n"
                + "WHERE nr_seq_object = ? \n"
                + "ORDER BY dt_insertion DESC;"),
        INSERT_USER("INSERT INTO application_user \n"
                + "(username, saltpass, interations, keylength, userpassword) \n"
                + "values (?, ?, ?, ?, ?);"),
        INSERT_OBJECT("INSERT INTO dictionary \n"
                + "(ds_name, ie_type, ds_content, dt_insertion, nm_user) \n"
                + "values (?, ?, ?, SYSDATE(), ?);"),
        DELETE_OBJECT("DELETE FROM dictionary \n"
                + " WHERE nr_sequence = ?;"),
        SELECT_OBJECT_TYPES("SELECT ds_object_type \n"
                + "FROM objects_types \n"
                + "ORDER BY cd_object_type;"),
        SELECT_ALL_USERS("SELECT username, fullname, isAdmin \n"
                + "FROM application_user \n"
                + "ORDER BY fullname;");

        private final String SQLCode;

        SQL(String sqlCode) {
            this.SQLCode = sqlCode;
        }

        public String getSqlCode() {
            return this.SQLCode;
        }
    }

    public enum Expressions {

    }

}
