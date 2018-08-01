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
                "SELECT NR_SEQUENCE NR_SEQUENCE, \n"
                + "1 QTD, \n"
                + "SALTPASS SALT, \n"
                + "INTERATIONS INTERA, \n"
                + "KEYLENGTH KEYL, \n"
                + "USER_PASSWORD PASS \n,"
                + "IS_ADMIN ADMIN  \n"
                + "FROM APPLICATION_USER \n"
                + "WHERE USERNAME = ?;"),
        SELECT_ALL_DICTIONARY(
                "SELECT NR_SEQUENCE NR_SEQUENCE, \n"
                + "DS_NAME DS_NAME, \n"
                + "CD_TYPE CD_TYPE, \n"
                + "GETOBJECTTYPEDS(CD_TYPE) DS_TYPE, \n"
                + "DS_CONTENT DS_CONTENT, \n"
                + "DT_INSERTION DT_INSERTION, \n"
                + "CD_USER CD_USER, \n"
                + "GETUSERUSERNAME(CD_USER) DS_USER, \n"
                + "IS_ACTIVE IS_ACTIVE \n"
                + "FROM DICTIONARY;"),
        SELECT_ONLY_ACTIVE_DICTIONARY(
                "SELECT NR_SEQUENCE NR_SEQUENCE, \n"
                + "DS_NAME DS_NAME, \n"
                + "CD_TYPE CD_TYPE, \n"
                + "GETOBJECTTYPEDS(CD_TYPE) DS_TYPE, \n"
                + "DS_CONTENT DS_CONTENT, \n"
                + "DT_INSERTION DT_INSERTION, \n"
                + "CD_USER CD_USER, \n"
                + "GETUSERUSERNAME(CD_USER) DS_USER, \n"
                + "IS_ACTIVE IS_ACTIVE \n"
                + "FROM DICTIONARY \n"
                + "WHERE IS_ACTIVE = 1 \n"
                + "OR IS_ACTIVE IS NULL ;"),
        SELECT_ONLY_INACTIVE_DICTIONARY(
                "SELECT NR_SEQUENCE NR_SEQUENCE, \n"
                + "DS_NAME DS_NAME, \n"
                + "CD_TYPE CD_TYPE, \n"
                + "GETOBJECTTYPEDS(CD_TYPE) DS_TYPE, \n"
                + "DS_CONTENT DS_CONTENT, \n"
                + "DT_INSERTION DT_INSERTION, \n"
                + "CD_USER CD_USER, \n"
                + "GETUSERUSERNAME(CD_USER) DS_USER, \n"
                + "IS_ACTIVE IS_ACTIVE \n"
                + "FROM DICTIONARY \n"
                + "WHERE IS_ACTIVE = 0;"),
        SELECT_ALL_DICTIONARY_HISTORY(
                "SELECT NR_SEQUENCE NR_SEQUENCE, \n"
                + "NR_SEQ_OBJECT NR_SEQ_OBJECT, \n"
                + "DS_CONTENT DS_CONTENT, \n"
                + "DT_INSERTION DT_INSERTION, \n"
                + "CD_USER CD_USER, \n"
                + "GETUSERUSERNAME(CD_USER) DS_USER \n"
                + "FROM DICTIONARY_HISTORY \n"
                + "WHERE NR_SEQ_OBJECT = ? \n"
                + "ORDER BY NR_SEQUENCE DESC;"),
        INSERT_USER("INSERT INTO APPLICATION_USER \n"
                + "(USERNAME,FULL_NAME, SALTPASS, INTERATIONS, KEYLENGTH, USER_PASSWORD, IS_ADMIN) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?);"),
        UPDATE_USER("UPDATE APPLICATION_USER \n"
                + "SET SALTPASS = ?, INTERATIONS = ?, KEYLENGTH = ?, USER_PASSWORD = ? \n"
                + "WHERE NR_SEQUENCE = ?;"),
        INSERT_OBJECT("INSERT INTO DICTIONARY \n"
                + "(DS_NAME, CD_TYPE, DS_CONTENT, DT_INSERTION, CD_USER, IS_ACTIVE) \n"
                + "VALUES (?, ?, ?, SYSDATE(), ?, 1);"),
        UPDATE_OBJECT("UPDATE DICTIONARY \n"
                + "SET DS_CONTENT = ?, CD_USER = ? \n"
                + "WHERE NR_SEQUENCE = ? \n"),
        DELETE_OBJECT("DELETE FROM DICTIONARY \n"
                + " WHERE NR_SEQUENCE = ?;"),
        SELECT_OBJECT_TYPES("SELECT DS_OBJECT_TYPE DS_OBJECT_TYPE \n"
                + "FROM OBJECTS_TYPES \n"
                + "WHERE CD_OBJECT_TYPE != -1 \n"
                + "ORDER BY CD_OBJECT_TYPE;"),
        SELECT_OBJECT_TYPES_CODE("SELECT GETOBJECTTYPECODE(?) OBJECT_CODE \n"
                + "FROM DUAL;"),
        SELECT_ALL_USERS("SELECT USERNAME, FULL_NAME, IS_ADMIN \n"
                + "FROM APPLICATION_USER \n"
                + "ORDER BY FULL_NAME;"),
        UPDATE_OBJECT_FLAG("UPDATE DICTIONARY \n"
                + "SET IS_ACTIVE = ? \n"
                + "WHERE NR_SEQUENCE = ?;");

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
