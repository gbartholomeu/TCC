/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author gbartholomeu
 */
public class Utilities {

    public static String validaString(Object o) {
        try {
            return String.valueOf(o);
        } catch (Exception e) {
            return "";
        }
    }

    public static String converteInt(Object o) {
        int numero = validaInt(o);
        return String.valueOf(numero);
    }

    public static Float validaFloat(Object o) {
        try {
            return Float.parseFloat(o.toString());
        } catch (Exception e) {
            return 0f;
        }

    }

    public static int validaInt(Object o) {
        try {
            return Integer.parseInt(o.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static long validaLong(Object o) {
        try {
            return Long.parseLong(o.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static double validaDouble(Object o) {
        try {
            return Double.valueOf(o.toString());
        } catch (Exception e) {

        }
        return 0;
    }

    public static boolean inEqualsIgnoreCase(String palava, String... contextos) {
        return palava.toUpperCase().contains(contextos.toString().toUpperCase());
    }

    public static Date getData(String d) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = format.parse(d);
        } catch (ParseException e) {
            System.out.println("Data em formato inválido.");
        }
        return data;
    }

    public static void objectEnabledControl(boolean enabled, Object... args) {
        if (args != null && args.length > 0) {
            for (Object obj : args) {
                if (obj instanceof Component) {
                    ((Component) obj).setEnabled(enabled);
                }
            }
        }
    }

    public static void objectVisibilityControl(boolean visible, Object... args) {
        if (args != null && args.length > 0) {
            for (Object obj : args) {
                if (obj instanceof Component) {
                    ((Component) obj).setVisible(visible);
                }
            }
        }
    }

}
