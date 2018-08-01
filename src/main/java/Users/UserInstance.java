/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *
 * @author gbartholomeu
 */
public class UserInstance {

    private static UserInstance instance;
    private static int usuarioAtivo;
    private static boolean isAdmin;

    public static UserInstance getInstance() {
        return (instance == null) ? new UserInstance() : instance;
    }

    public static void setUsuarioAtivo(int usuario) {
        usuarioAtivo = usuario;
    }

    public static int getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public static void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public static boolean isAdmin() {
        return isAdmin;
    }
}
