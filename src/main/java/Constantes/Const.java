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
                + "       userpassword PASS \n"
                + "FROM application_user \n"
                + "WHERE username = ?;"),
        SELECT_ALL_DICIONARIO(
                "SELECT * "
                + "FROM dicionario;"),
        INSERT_USER("INSERT INTO application_user \n"
                + "(username, saltpass, interations, keylength, userpassword) \n"
                + "values (?, ?, ?, ?, ?);"),
        INSERT_OBJECT("INSERT INTO dicionario \n"
                + "(ds_nome, ie_tipo, ds_conteudo, dt_insercao, nm_usuario) \n"
                + "values (?, ?, ?, SYSDATE(), ?);");

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
